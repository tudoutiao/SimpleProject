package com.my.base.customview


interface ICustomView<VIEW_MODEL : BaseCustomViewModel?> {
    fun setData(data: VIEW_MODEL)
}
