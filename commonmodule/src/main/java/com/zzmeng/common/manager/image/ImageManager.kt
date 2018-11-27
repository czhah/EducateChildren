package com.zzmeng.common.manager.image

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions


open class ImageManager private constructor() : IImageListener {

    private var imageManager: IImageListener? = null

    init {
        this.imageManager = GlideManager()
    }

    companion object {
        var INSTANCE: ImageManager = ImageManager()
    }

    override fun load(context: Activity, imageView: ImageView, path: String) {
        imageManager?.load(context, imageView, path)
    }

    override fun load(context: Activity, imageView: ImageView, path: String, options: RequestOptions) {
        imageManager?.load(context, imageView, path, options)
    }

    override fun load(context: Activity, path: String, options: RequestOptions, listener: IDownloadListener?) {
        imageManager?.load(context, path, options, listener)
    }

    override fun load(context: Activity, imageView: ImageView, path: String, isGif: Boolean, options: RequestOptions) {
        imageManager?.load(context, imageView, path, isGif, options)
    }
}