package com.zzmeng.educatechildren.contract

import com.zzmeng.common.mvp.IModel
import com.zzmeng.common.mvp.IPresenter
import com.zzmeng.common.mvp.IView

interface MainContract {

    interface Model : IModel

    interface View : IView {
        fun add()
    }

    interface Presenter : IPresenter
}