package com.zzmeng.common.manager.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions

interface IImageListener {

    //  上下文、imageView、path
    fun load(context: Context, imageView: ImageView, path: String)

    fun load(context: Context, imageView: ImageView, path: String, options: RequestOptions)

}