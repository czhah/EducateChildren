package com.zzmeng.common.mvp

import android.content.Intent

open class BasePresenter<M : IModel, V : IView> @JvmOverloads constructor(protected var mModel: M?, protected var mView: V?) : IPresenter {

    override fun initData(intent: Intent) {
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
        mModel?.onDestroy()
        mModel = null
        mView = null
    }
}