package com.zzmeng.common.mvp

interface IView {

    fun showLoading()

    fun showLoading(resId: Int)

    fun showLoading(hint: String)

    fun hideLoading()

    fun showMessage(message: String)

    fun showMessage(resId: Int)

}