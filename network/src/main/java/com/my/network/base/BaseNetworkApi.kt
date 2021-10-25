package com.my.network.base

import com.my.network.apiresponse.MoshiResultTypeAdapterFactory
import com.my.network.apiresponse.NetworkResponseAdapterFactory
import com.my.network.error.GlobalErrorHandler
import com.my.network.interceptor.CommonRequestInterceptor
import com.my.network.interceptor.CommonResponseInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseNetworkApi {
    var mRetrofit: Retrofit
    val globalErrorHandler = GlobalErrorHandler()

    companion object {
        var iNetworkReqiredInfo: INetworkReqiredInfo? = null
        fun init(networkReqiredInfo: INetworkReqiredInfo) {
            iNetworkReqiredInfo = networkReqiredInfo
        }
    }

    val moshi = Moshi.Builder()
        //结果转化
        .add(MoshiResultTypeAdapterFactory(getEnvelopeHandler()))
        .addLast(KotlinJsonAdapterFactory())
        .build()

    open fun <T> getService(service: Class<T>?): T {
        return mRetrofit.create(service)
    }

    constructor(baseUrl: String) {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getOkhttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            //返回拦截  添加异常适配器
            .addCallAdapterFactory(NetworkResponseAdapterFactory(globalErrorHandler))

        mRetrofit = retrofitBuilder.build()
    }

    fun log(msg: Any?) = println("${Thread.currentThread().name}--$msg")

    /**
     * 获取okhttpclient
     * 添加logging打印、请求、返回拦截器
     */
    fun getOkhttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES)
            .readTimeout(10, TimeUnit.MINUTES) // 读取超时
            .writeTimeout(10, TimeUnit.MINUTES) // 写超时
        iNetworkReqiredInfo?.let {
            okHttpClient
                .addInterceptor(CommonRequestInterceptor(it))
                .addInterceptor(CommonResponseInterceptor(it))
        }

        if (null != getInterceptor()) {
            okHttpClient.addInterceptor(getInterceptor()!!)
        }

        if (null != iNetworkReqiredInfo && iNetworkReqiredInfo!!.isDebug()) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            //设置日志的打印级别，  BASEIC:请求/响应行；HEADER:请求/响应行 + 头；BODY:请求/响应航 + 头 + 体
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClient.addInterceptor(httpLoggingInterceptor)
        }
        return okHttpClient.build()
    }

    //域名不同拦击处理不同
    protected abstract fun getInterceptor(): Interceptor?

    //baseresponse不同，处理不同
    protected open fun getEnvelopeHandler(): MoshiResultTypeAdapterFactory.Envelope? {
        return null
    }


}