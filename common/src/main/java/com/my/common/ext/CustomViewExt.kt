package com.my.base.ext

import android.app.Activity
import android.view.inputmethod.InputMethodManager

/**
 *  author : liuxue
 *  date : 2021/11/3 0003 19:00
 *  description :
 */
/**
 * 隐藏软键盘
 */
fun hideSoftKeyboard(activity: Activity?) {
    activity?.let { act ->
        val view = act.currentFocus
        view?.let {
            val inputMethodManager =
                act.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}