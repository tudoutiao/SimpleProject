package com.my.network.apiresponse

import com.my.network.error.BusinessException
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class NetworkResponseAdapterFactory(val failureHandler: FailureHandler? = null) :
    CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        //suspend functions wrap the response type in call
        if (Call::class.java != getRawType(returnType)) return null


        //check fires that the return type is ParameterizedType
        check(returnType is ParameterizedType) {
            "return type must be parameterized as Call<NetworkResponse<Foo>> or Call<NetworkResponse<out Foo>>"
        }

        //get the response type inside the Call type
        val responseType = getParameterUpperBound(0, returnType)
        //if the response type is not ApiResponse then we can not handle this type,so we return null
        if (getRawType(responseType) != NetworkResponse::class.java) {
            return null
        }

        //the response type is ApiResponse and should be parameterized
        check(responseType is ParameterizedType)

        return NetworkResponseAdapter<Any>(responseType,failureHandler)

    }

    interface FailureHandler {
        fun onFailure(throwable: BusinessException)
    }

}