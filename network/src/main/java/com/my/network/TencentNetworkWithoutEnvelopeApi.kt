package com.my.network

import android.util.Log
import com.my.network.apiresponse.MoshiResultTypeAdapterFactory
import com.my.network.base.BaseNetworkApi
import com.my.network.utils.TecentUtil
import okhttp3.Interceptor

/**
 * 不带baseResponse
 */
object TencentNetworkWithoutEnvelopeApi : BaseNetworkApi("https://www.wanandroid.com/") {
    override fun getInterceptor(): Interceptor? {
        return Interceptor {
            val builder = it.request().newBuilder()
            //可以添加请求head
            Log.e("WithoutEnvelopeApi", "----发送请求--" + TecentUtil.getTimeStr())
            it.proceed(builder.build())
        }
    }

    /**
     * 返回数据结构没有baseResponse时，进行拆封处理，组织成包含baseResponse结构
     */
    override fun getEnvelopeHandler(): MoshiResultTypeAdapterFactory.Envelope? {
        return object : MoshiResultTypeAdapterFactory.Envelope {
            override fun getStatusCodeKey(): String {
                return "errorCode"
            }

            override fun getErrorMessageKey(): String {
                return "errorMsg"
            }

            override fun getDataKey(): String {
                return "data"
            }

            override fun doseStatusCodeIndicateSuccess(statusCode: Int): Boolean {
                return statusCode == 0
            }

            override fun isNeedOpenEnvelope(): Boolean {
                return isNeeToOpenEnvelope()
            }
        }
    }

    fun isNeeToOpenEnvelope(): Boolean {
        return false
    }

}