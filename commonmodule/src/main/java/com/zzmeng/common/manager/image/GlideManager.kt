package com.zzmeng.common.manager.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GlideManager : IImageListener {

    override fun load(context: Context, imageView: ImageView, path: String) {
        Glide.with(context).asBitmap().load(path).into(imageView)
    }

    override fun load(context: Context, imageView: ImageView, path: String, options: RequestOptions) {
        Glide.with(context).asBitmap().apply(options).load(path).into(imageView)
    }
}