package com.zzmeng.common.manager.image

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions


class ImageManager private constructor() : IImageListener {

    private var imageManager: IImageListener? = null

    init {
        Log.i("cz", "init")
        this.imageManager = GlideManager()
    }

    companion object {
        var INSTANCE: ImageManager = ImageManager()
    }

    override fun load(context: Context, imageView: ImageView, path: String) {
        imageManager?.load(context, imageView, path)
    }

    override fun load(context: Context, imageView: ImageView, path: String, options: RequestOptions) {
        imageManager?.load(context, imageView, path, options)
    }
}