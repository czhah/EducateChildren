package com.zzmeng.common.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/** Create by chenzhuang on 2018/11/27 0027 下午 8:27
 *      网络帮助类
 */
object NetWorkUtils {

    /**
     * 获取当前网络状态
     */
    fun getCurrentNetworkState(context: Context): NetworkInfo.State? {
        val networkInfo = (context.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        return networkInfo?.state
    }

    /**
     * 判断当前网络是否已经连接
     */
    fun isConnectedByState(context: Context): Boolean {
        return getCurrentNetworkState(context) == NetworkInfo.State.CONNECTED
    }
}