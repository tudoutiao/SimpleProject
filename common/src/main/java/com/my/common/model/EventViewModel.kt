package com.my.common.model

import com.my.base.base.BaseViewModel
import com.my.base.livedata.EventLiveData

/**
 *  author : liuxue
 *  date : 2021/11/4 0004 12:25
 *  description :APP全局的ViewModel，可以在这里发送全局通知替代EventBus，LiveDataBus等
 */
class EventViewModel: BaseViewModel() {
    //添加TODO通知
    val todoEvent = EventLiveData<Boolean>()
}