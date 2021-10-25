package com.my.network.base

import android.app.Application

interface INetworkReqiredInfo {
    fun getAppVersionName(): String
    fun getAppVersionCode(): String
    fun isDebug(): Boolean
    fun getApplicationContext(): Application
    fun getUserAgent(): String
    fun getDeviceId(): String
    fun getSource(): String
}
