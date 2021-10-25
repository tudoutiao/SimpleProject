package com.my.network.interceptor

import com.my.network.base.INetworkReqiredInfo
import okhttp3.FormBody
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

open class CommonRequestInterceptor(val requireInfo: INetworkReqiredInfo) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
//        if (request.method.equals("POST")) {
//            var body = request.body
//            if (body is FormBody) {
//                val bodyBuilder = FormBody.Builder()
//                //保存原始请求参数
//                for (i in 0 until body.size) {
//                    bodyBuilder.addEncoded(body.encodedName(i), body.encodedValue(i))
//                }
//                //添加默认参数
//                body = bodyBuilder.addEncoded("version", requireInfo.getAppVersionName())
//                    .addEncoded("deviceId", requireInfo.getDeviceId())
//                    .addEncoded("source", requireInfo.getSource())
//                    .build()
//                request = request.newBuilder().post(body).build();
//
//            }
//        } else if(request.method.equals("GET")){
//            var modifiedUrl: HttpUrl = request.url.newBuilder()
//                .addQueryParameter("version", requireInfo.getAppVersionName())
//                .addQueryParameter("deviceId", requireInfo.getDeviceId())
//                .addQueryParameter("source", requireInfo.getSource())
//                .build()
//            request = request.newBuilder().url(modifiedUrl).build()
//        }
//
//        var builder = request.newBuilder()
//        builder.addHeader("user-Agent", requireInfo.getUserAgent())

//        return chain.proceed(builder.build())
        return chain.proceed(request)
    }
}