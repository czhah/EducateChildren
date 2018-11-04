package com.zzmeng.common.mvp

import android.content.Intent

interface IPresenter {

    fun initData(intent: Intent)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?)

    fun onDestroy()

}