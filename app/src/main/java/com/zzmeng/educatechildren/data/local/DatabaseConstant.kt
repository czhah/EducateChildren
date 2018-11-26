package com.zzmeng.educatechildren.data.local

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/** Create by chenzhuang on 2018/11/26 0026 上午 11:18
 *
 */
object DatabaseConstant{

    const val DB_NAME = "educate_child.db"
    const val DB_VERSION = 1

    const val TB_USER_NAME = "tb_user"
    const val FIELD_USER_ID = "user_id"
    const val FIELD_USER_NICKNAME = "user_nickname"
    const val FIELD_USER_ACCOUNT = "user_account"
    const val FIELD_USER_AVATAR = "user_avatar"
    const val FIELD_USER_GENDER = "user_gender"

    @SuppressLint("MissingPermission")
    fun getCurrentNetworkState(context: Context): NetworkInfo.State? {
        val networkInfo = (context.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        return networkInfo?.state
    }

    fun isConnectedByState(context: Context): Boolean {
        return getCurrentNetworkState(context) == NetworkInfo.State.CONNECTED
    }
}