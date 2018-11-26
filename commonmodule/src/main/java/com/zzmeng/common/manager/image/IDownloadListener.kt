package com.zzmeng.common.manager.image

import android.graphics.Bitmap

interface IDownloadListener {

    fun downloadSuccess(bitmap: Bitmap)

    fun downloadFailed()
}