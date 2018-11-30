package com.zzmeng.common.util

import android.app.Activity
import android.content.Context
import android.text.Selection
import android.text.Spannable
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/** Create by chenzhuang on 2018/11/27 0027 下午 8:14
 *      软键盘
 */
object InputMethodUtils {

    /**
     * 为给定的编辑器开启软键盘
     *
     * @param editText 给定的编辑器
     */
    fun openSoftKeyboard(context: Context, editText: EditText) {
        editText.requestFocus()
        val inputMethodManager = context.getSystemService(
                Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText,
                InputMethodManager.SHOW_IMPLICIT)
        setEditTextSelectionToEnd(editText)
    }

    fun setEditTextSelectionToEnd(editText: EditText) {
        val editable = editText.editableText
        Selection.setSelection(editable as Spannable,
                editable.toString().length)
    }
    /**
     * 关闭软键盘
     */
    fun closeSoftKeyboard(activity: Activity) {
        //隐藏软键盘
        val view = activity.window.peekDecorView()
        if (view != null) {
            val inputmanger = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputmanger.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}