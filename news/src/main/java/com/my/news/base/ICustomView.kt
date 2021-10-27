package com.my.news.base


interface ICustomView<VIEW_MODEL : BaseCustomViewModel?> {
    fun setData(data: VIEW_MODEL)
}
