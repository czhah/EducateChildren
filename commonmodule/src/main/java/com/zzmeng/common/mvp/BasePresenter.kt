package com.zzmeng.common.mvp

import android.content.Context
import android.content.Intent

class BasePresenter(protected var mContext: Context?, protected var mView: IView?) : IPresenter {

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
    }

    override fun onDestroy() {
        mContext = null
        mView = null
    }
}