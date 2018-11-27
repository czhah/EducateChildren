package com.zzmeng.common.manager.image

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

internal class GlideManager : IImageListener {

    override fun load(context: Activity, imageView: ImageView, path: String) {
        this.load(context, imageView, path, ImageOptions.getInstance().build())
    }

    override fun load(context: Activity, imageView: ImageView, path: String, options: RequestOptions) {
        Glide.with(context).asBitmap().load(path).into(imageView)
    }

    override fun load(context: Activity, path: String, options: RequestOptions, listener: IDownloadListener?) {
        Glide.with(context).asBitmap().apply(options).load(path).into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                listener?.downloadSuccess(resource)
            }
        })
    }

    override fun load(context: Activity, imageView: ImageView, path: String, isGif: Boolean, options: RequestOptions) {
        if (isGif) {
            this.load(context, imageView, path, options)
        } else {
            Glide.with(context).asGif().apply(options).load(path).into(imageView)
        }
    }

}