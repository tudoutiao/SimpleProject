package com.my.network

import android.util.Log
import com.my.network.base.BaseNetworkApi
import com.my.network.utils.TecentUtil
import okhttp3.Interceptor

/**
 * 带baseresponse
 */
object TencentNetworkWithEnvelopeApi : BaseNetworkApi("https://www.wanandroid.com/") {
    override fun getInterceptor(): Interceptor? {
        return Interceptor {
            val builder = it.request().newBuilder()
            //可以添加请求head
            Log.e("WithEnvelopeApi", "----发送请求--" + TecentUtil.getTimeStr())
            it.proceed(builder.build())
        }
    }
}