package com.zzmeng.common.manager.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions

internal interface IImageListener {

    //  上下文、imageView、path
    fun load(context: Context, imageView: ImageView, path: String)

    fun load(context: Context, imageView: ImageView, path: String, options: RequestOptions)

    fun load(context: Context, path: String, options: RequestOptions, listener: IDownloadListener?)

    fun load(context: Context, imageView: ImageView, path: String, isGif: Boolean, options: RequestOptions)

}