package com.zzmeng.common.manager

import com.bumptech.glide.request.RequestOptions
import kotlin.jvm.internal.Intrinsics

class AppManager {

    fun options(loadingId: Int, errorId: Int, width: Int, height: Int): RequestOptions {
        val var10000 = RequestOptions.overrideOf(width, height).placeholder(loadingId).error(errorId)
        Intrinsics.checkExpressionValueIsNotNull(var10000, "RequestOptions.overrideO…loadingId).error(errorId)")
        return var10000
    }

    companion object {
        val INSTANCE: AppManager

        init {
            val var0 = AppManager()
            INSTANCE = var0
        }
    }
}
