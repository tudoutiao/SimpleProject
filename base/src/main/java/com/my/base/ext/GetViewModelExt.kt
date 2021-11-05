package com.my.base.ext

import java.lang.reflect.ParameterizedType

/**
 *  author : liuxue
 *  date : 2021/11/1 0001 17:40
 *  description :
 */

/**
 * 获取当前类绑定的泛型ViewModel-clazz
 */
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}
