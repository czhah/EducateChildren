package com.zzmeng.common

import android.app.Application

/**
 * Applicateion基类
 */
open class BaseApplication : Application() {

    companion object {
        var INSTANCE: Application? = null
    }

    override fun onCreate() {
        super.onCreate()
        BaseApplication.INSTANCE = this
    }
}