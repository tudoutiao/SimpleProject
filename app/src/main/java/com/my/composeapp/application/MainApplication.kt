package com.my.myapp.application

import android.app.Application
import android.content.Context
import com.my.network.base.BaseNetworkApi

class MainApplication : Application() {
    lateinit var app: Context
    override fun onCreate() {
        super.onCreate()
        BaseNetworkApi.Companion.init(NetworkRequiredInfo(this))
    }
}