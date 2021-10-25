package com.my.network.apiresponse

import com.my.network.bean.TencentBaseResponse
import com.my.network.error.BusinessException
import com.my.network.utils.MoshiUtils
import okhttp3.Request
import okio.IOException
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 异常分类
 */
class NetworkResponseCall<S : Any>(
    val delegate: Call<S>,
    val errorConverter: NetworkResponseAdapterFactory.FailureHandler?
) : Call<NetworkResponse<S>> {
    override fun enqueue(callback: Callback<NetworkResponse<S>>) {
        return delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()
                val message = response.message()
                if (response.isSuccessful) {
                    //[200..300]
                    if (null != body) {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.Success(body))
                        )
                    } else {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.UnknownError(null))
                        )
                    }
                } else if (code == 400) {//bad request 未执行到fail ？？？？？
                    callback.onResponse(
                        this@NetworkResponseCall,
                        Response.success(NetworkResponse.NetworkError(message, code))
                    )

                    errorConverter?.onFailure(
                        BusinessException(
                            code ?: -1,
                            message ?: ""
                        )
                    )

                } else {
                    if (null != error && error.contentLength() > 0) {
                        //500X
                        val errorResponse =
                            MoshiUtils.fromJson<TencentBaseResponse>(
                                error!!.toString(),
                                TencentBaseResponse::class.java
                            )
                        errorConverter?.onFailure(
                            BusinessException(
                                errorResponse?.errorCode ?: -1,
                                errorResponse?.errorMsg ?: ""
                            )
                        )
                        callback.onResponse(
                            this@NetworkResponseCall, Response.success(
                                NetworkResponse.ApiError(
                                    errorResponse?.errorMsg ?: "",
                                    errorResponse?.errorCode ?: -1
                                )
                            )
                        )
                    } else {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(
                                NetworkResponse.NetworkError(
                                    error?.string() ?: "Message is empty", code
                                )
                            )
                        )
                    }
                }
            }

            override fun onFailure(call: Call<S>, t: Throwable) {
                val networkResponse = when (t) {
                    is IOException ->
                        NetworkResponse.NetworkError(t.message.toString(), 400)
                    else -> NetworkResponse.UnknownError(t)
                }
                callback.onResponse(this@NetworkResponseCall, Response.success(networkResponse))
            }
        })
    }

    override fun clone(): Call<NetworkResponse<S>> =
        NetworkResponseCall(delegate.clone(), errorConverter)

    override fun execute(): Response<NetworkResponse<S>> {
        throw UnsupportedOperationException("NetworkResponseCall dose not support execute")
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()


}