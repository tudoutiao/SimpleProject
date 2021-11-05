package com.my.base.net

import com.my.base.livedata.EventLiveData

/**
 *  author : liuxue
 *  date : 2021/11/3 0003 12:11
 *  description : 网络状态变更管理
 */
class NetworkStateManager private constructor() {
        val mNetworkStateCallback = EventLiveData<NetState>()
    companion object {
        //双重校验锁式 单例模式
        val instance: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }
}