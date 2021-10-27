package com.my.news.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseCustomView<VIEW_BINDING : ViewDataBinding, VIEW_MODEL : BaseCustomViewModel> :
    LinearLayout, ICustomView<VIEW_MODEL>, View.OnClickListener {

    open var dataBinding: VIEW_BINDING? = null
        get() {
            return dataBinding
        }
    open var viewModel: VIEW_MODEL? = null
        get() {
            return viewModel
        }


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    fun init() {
        val inflater =
            this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (setViewLayoutId() != 0) {
            dataBinding = DataBindingUtil.inflate(inflater, setViewLayoutId(), this, false)
            dataBinding!!.getRoot().setOnClickListener { view -> onRootClick(view) }
            this.addView(dataBinding!!.getRoot())
        }
    }


    override fun setData(data: VIEW_MODEL) {
        viewModel = data
        setDataToView(viewModel!!)
        if (dataBinding != null) {
            dataBinding!!.executePendingBindings()
        }
    }

    override fun onClick(v: View?) {
    }

    /**设置layoutid*/
    protected abstract fun setViewLayoutId(): Int

    /**view点击*/
    protected abstract fun onRootClick(view: View)

    /**model传递*/
    protected abstract fun setDataToView(data: VIEW_MODEL)


}