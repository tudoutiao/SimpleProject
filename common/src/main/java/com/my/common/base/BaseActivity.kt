package com.my.common.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.my.base.base.BaseViewModel
import com.my.base.base.BaseVmDbActivity
import com.my.base.ext.dismissLoadingExt
import com.my.base.ext.showLoadingExt

/**
 *  author : liuxue
 *  date : 2021/10/28 0028 18:16
 *  description :
 *   你项目中的Activity基类，在这里实现显示弹窗，吐司，还有加入自己的需求操作 ，如果不想用Databind，请继承
 * BaseVmActivity例如
 * abstract class BaseActivity<VM : BaseViewModel> : BaseVmActivity<VM>() {
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmDbActivity<VM, DB>(){
    abstract override fun layoutId(): Int

    abstract override fun initView(savedInstanceState: Bundle?)

    /**
     * 创建liveData观察者
     */
    override fun createObserver() {}

    /**
     * 打开等待框
     */
    override fun showLoading(message: String) {
        showLoadingExt(message)
    }

    /**
     * 关闭等待框
     */
    override fun dismissLoading() {
        dismissLoadingExt()
    }
}