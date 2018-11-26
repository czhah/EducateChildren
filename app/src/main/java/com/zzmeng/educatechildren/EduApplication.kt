package com.zzmeng.educatechildren

import android.app.Application

/** Create by chenzhuang on 2018/11/26 0026 下午 5:38
 *
 */
class EduApplication: Application() {

    companion object {
        var INSTANCE: Application? = null
    }

    override fun onCreate() {
        super.onCreate()
        EduApplication.INSTANCE = this
    }

}