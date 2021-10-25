package com.my.network.apiresponse

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class NetworkResponseAdapter<S : Any>(
    val delegate: Type,
    val failureHandler: NetworkResponseAdapterFactory.FailureHandler?
) : CallAdapter<S, Call<NetworkResponse<S>>> {
    override fun responseType(): Type {
        return delegate
    }

    override fun adapt(call: Call<S>): Call<NetworkResponse<S>> {
        return NetworkResponseCall(call, failureHandler)
    }

}