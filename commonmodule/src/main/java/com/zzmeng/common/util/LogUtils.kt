package com.zzmeng.common.util

import android.util.Log

/** Create by chenzhuang on 2018/11/27 0027 下午 8:12
 *      日志类
 */
object LogUtils {

    private const val DEBUG = true
    private const val TAG = "Educate"

    fun e(msg: String) {
        if (DEBUG) Log.e(TAG, "-------------------------:$msg")
    }

    fun e(tag: String, msg: String) {
        if (DEBUG) Log.e(tag, "-------------------------:$msg")
    }

    fun e(tag: String, msg: String, throwable: Throwable) {
        if (DEBUG) Log.e(tag, "-------------------------:$msg", throwable)
    }

    fun i(msg: String) {
        if (DEBUG) Log.i(TAG, "-------------------------:$msg")
    }

    fun i(tag: String, msg: String) {
        if (DEBUG) Log.i(tag, "-------------------------:$msg")
    }

    fun i(tag: String, msg: String, throwable: Throwable) {
        if (DEBUG) Log.i(tag, "-------------------------:$msg", throwable)
    }

    fun d(tag: String, msg: String) {
        if (DEBUG) Log.d(tag, "-------------------------:$msg")
    }

    fun d(msg: String) {
        if (DEBUG) Log.d(TAG, "-------------------------:$msg")
    }

    fun v(msg: String) {
        if (DEBUG) Log.v(TAG, "-------------------------:$msg")
    }

    fun v(tag: String, msg: String) {
        if (DEBUG) Log.v(tag, "-------------------------]:$msg")
    }

    fun w(throwable: Throwable) {
        if (DEBUG) Log.w(TAG, "-------------------------:$throwable")
    }

    fun w(tag: String, throwable: Throwable) {
        if (DEBUG) Log.w(tag, "-------------------------:$throwable")
    }
}