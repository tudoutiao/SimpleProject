package com.my.common.imgview

import android.content.Context
import android.view.View
import android.widget.Toast
import com.my.base.customview.BaseCustomView
import com.my.common.R
import com.my.common.databinding.ItemImgTitleViewBinding
import com.my.news.newslist.views.imgview.ImgTitleViewViewModel

class ImgTitleView(context: Context) :
    BaseCustomView<ItemImgTitleViewBinding, ImgTitleViewViewModel>(context) {

    override fun setViewLayoutId(): Int = R.layout.item_img_title_view

    override fun onRootClick(view: View) {
        Toast.makeText(context, "点击img item", Toast.LENGTH_SHORT).show()

    }

    override fun setDataToView(data: ImgTitleViewViewModel) {
        dataBinding!!.viewModel = data
    }
}