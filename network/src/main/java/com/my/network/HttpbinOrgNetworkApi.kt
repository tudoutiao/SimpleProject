package com.my.network

import com.my.network.base.BaseNetworkApi
import okhttp3.Interceptor

object HttpbinOrgNetworkApi : BaseNetworkApi("https://www.wanandroid.com/") {
    override fun getInterceptor(): Interceptor? {
        return null
    }


}