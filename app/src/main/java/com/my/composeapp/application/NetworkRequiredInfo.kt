package com.my.myapp.application

import android.app.Application
import com.my.composeapp.BuildConfig
import com.my.network.base.INetworkReqiredInfo

class NetworkRequiredInfo(val application: Application) : INetworkReqiredInfo {


    override fun getAppVersionName(): String {
        return BuildConfig.VERSION_NAME
    }

    override fun getAppVersionCode(): String {
        return "${BuildConfig.VERSION_CODE}"
    }

    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

    override fun getApplicationContext(): Application {
        return application
    }

    override fun getUserAgent(): String {
        return "chouti/${getAppVersionName()}/channel_chouti (${
            System.getProperty(
                "http.agent"
            )
        } )"
    }

    override fun getDeviceId(): String {
        return "aadff67"
    }

    override fun getSource(): String {
        return "6ab02e01b94cf80c96d2bf9a70dd5bd7"
    }
}