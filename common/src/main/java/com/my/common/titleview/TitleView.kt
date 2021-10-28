package com.my.common.titleview

import android.content.Context
import android.view.View
import android.widget.Toast
import com.my.base.customview.BaseCustomView
import com.my.common.R
import com.my.common.databinding.ItemTitleViewBinding
import com.my.news.newslist.views.titleview.TitleViewViewModel

class TitleView(context: Context) :
    BaseCustomView<ItemTitleViewBinding, TitleViewViewModel>(context) {

    override fun setViewLayoutId(): Int = R.layout.item_title_view

    override fun onRootClick(view: View) {
        Toast.makeText(context, "点击text item", Toast.LENGTH_SHORT).show()
    }

    override fun setDataToView(data: TitleViewViewModel) {
        dataBinding!!.viewModel = data
    }


}