package com.my.myapp.application

import android.content.Context
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.my.base.base.BaseApp
import com.my.common.model.AppViewModel
import com.my.common.model.EventViewModel
import com.my.network.base.BaseNetworkApi
import com.tencent.mmkv.MMKV
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.EmptyCallback
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.ErrorCallback
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.LoadingCallback

//Application全局的ViewModel，里面存放了一些账户信息，基本配置信息等
val appViewModel: AppViewModel by lazy { MainApplication.appViewModelInstance }

//Application全局的ViewModel，用于发送全局通知操作
val eventViewModel: EventViewModel by lazy { MainApplication.eventViewModelInstance }

class MainApplication : BaseApp() {

    companion object {
        lateinit var instance: MainApplication
        lateinit var eventViewModelInstance: EventViewModel
        lateinit var appViewModelInstance: AppViewModel
    }

    lateinit var app: Context
    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
        instance = this
        eventViewModelInstance = getAppViewModelProvider().get(EventViewModel::class.java)
        appViewModelInstance = getAppViewModelProvider().get(AppViewModel::class.java)
        //界面加载管理 初始化
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(ErrorCallback())//错误
            .addCallback(EmptyCallback())//空
            .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
            .commit()


        BaseNetworkApi.Companion.init(NetworkRequiredInfo(this))

    }
}