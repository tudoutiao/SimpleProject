package com.my.common.model

import com.my.base.base.BaseViewModel

/**
 *  author : liuxue
 *  date : 2021/11/4 0004 12:27
 *  description :APP全局的ViewModel，可以存放公共数据，当他数据改变时，所有监听他的地方都会收到回调,也可以做发送消息
 * 比如 全局可使用的 地理位置信息，账户信息,App的基本配置等等，
 */
class AppViewModel : BaseViewModel() {

}