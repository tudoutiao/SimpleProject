package com.my.news.newslist.views.imgview

import android.content.Context
import android.view.View
import android.widget.Toast
import com.my.news.R
import com.my.news.base.BaseCustomView
import com.my.news.databinding.ItemImgTitleViewBinding

class ImgTitleView(context: Context) :
    BaseCustomView<ItemImgTitleViewBinding, ImgTitleViewViewModel>(context) {

    override fun setViewLayoutId(): Int= R.layout.item_img_title_view

    override fun onRootClick(view: View) {
        Toast.makeText(context, "点击img item", Toast.LENGTH_SHORT).show()

    }

    override fun setDataToView(data: ImgTitleViewViewModel) {
        dataBinding!!.viewmodel=data
    }
}