package com.my.network.interceptor

import android.util.Log
import com.my.network.base.INetworkReqiredInfo
import okhttp3.Interceptor
import okhttp3.Response

open class CommonResponseInterceptor(val requireInfo: INetworkReqiredInfo):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var requestTime=System.currentTimeMillis()
        var response=chain.proceed(chain.request())
        Log.d("----","requestTime :"+requestTime)
        return response
    }
}