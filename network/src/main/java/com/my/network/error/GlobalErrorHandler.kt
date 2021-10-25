package com.my.network.error

import com.my.network.apiresponse.NetworkResponseAdapterFactory

/**
 * 统一异常处理器  转换异常
 */
class GlobalErrorHandler : NetworkResponseAdapterFactory.FailureHandler {
    override fun onFailure(throwable: BusinessException) {
        when (throwable.code) {
            2096 -> {

            }
            3099 -> {

            }
            400 -> {
            }
        }
    }

}