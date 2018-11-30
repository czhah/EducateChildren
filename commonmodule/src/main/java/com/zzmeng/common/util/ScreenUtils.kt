package com.zzmeng.common.util

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.util.DisplayMetrics

/** Create by chenzhuang on 2018/11/27 0027 下午 8:24
 *      屏幕帮助类
 */
object ScreenUtils {

    /**
     * 把dp转成px
     *
     * @param context
     * @param dpVal
     * @return
     */
    fun dp2px(context: Context, dpVal: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpVal * scale + 0.5f).toInt()
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxVal
     * @return
     */
    fun px2dp(context: Context, pxVal: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxVal / scale + 0.5f).toInt()
    }

    /**
     * sp转px
     *
     * @param context context
     * @param spVal   value
     * @return pixel value
     */
    fun sp2px(context: Context, spVal: Int): Float {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spVal * fontScale + 0.5f)
    }

    /**
     * px转sp
     *
     * @param context
     * @param pxVal
     * @return
     */
    fun px2sp(context: Context, pxVal: Int): Float {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxVal / fontScale + 0.5f)
    }

    /**
     * 获取屏幕密度
     *
     * @param context
     * @return
     */
    fun getDensity(context: Context): Float {
        val metric = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(metric)
        return metric.density  // 屏幕密度（0.75 / 1.0 / 1.5）
    }

    /**
     * 获取屏幕宽度
     *
     * @param mContext
     * @return
     */
    fun getScreenWidth(mContext: Context): Int {
        val display = (mContext as Activity).windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        return point.x
    }

    /**
     * 获取屏幕高度
     *
     * @param mContext
     * @return
     */
    fun getScreenHeight(mContext: Context): Int {
        val display = (mContext as Activity).windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        return point.y
    }
}