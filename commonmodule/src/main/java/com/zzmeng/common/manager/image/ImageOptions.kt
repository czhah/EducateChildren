package com.zzmeng.common.manager.image

import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class ImageOptions private constructor() {

    private var loadingId: Int = -1
    private var errorId: Int = -1
    private var width: Int = -1
    private var height: Int = -1
    private var isCache: Boolean = false
    private var isCircle: Boolean = false
    private var dontAnimate: Boolean = false
    private var radius: Int = -1

    companion object {
        fun getInstance(): ImageOptions {
            return ImageOptions()
        }
    }

    fun placeholder(resId: Int): ImageOptions {
        this.loadingId = resId
        return this
    }

    fun error(resId: Int): ImageOptions {
        this.errorId = resId
        return this
    }

    fun override(w: Int, h: Int): ImageOptions {
        this.width = w
        this.height = h
        return this
    }

    fun dontAnimate(): ImageOptions {
        this.dontAnimate = true
        return this
    }

    fun setCache(): ImageOptions {
        this.isCache = true
        return this
    }

    fun setCircle(): ImageOptions {
        this.isCircle = true
        return this
    }

    fun setCorners(radius: Int): ImageOptions {
        this.radius = radius
        return this
    }

    //  加载中图片、加载失败图片、图片大小、是否缓存、加载gif、获取bitmap(下载)、圆角、圆形
    fun build(): RequestOptions {
        val options: RequestOptions = when {
            isCircle -> RequestOptions().circleCrop()
            radius != -1 -> {
                val roundedCorners = RoundedCorners(radius)
                RequestOptions.bitmapTransform(roundedCorners)
            }
            else -> RequestOptions()
        }
        options.diskCacheStrategy(if (isCache) DiskCacheStrategy.RESOURCE else DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
        if (width != -1 && height != -1) //图片大小
            options.override(width, height)
        if (errorId != -1) //错误图片
            options.error(errorId)
        if (dontAnimate) //是否需要动画
            options.dontAnimate()
        if (loadingId != -1) //  占位图
            options.placeholder(loadingId)
        return options
    }

    fun buildDefault(): RequestOptions {
        return RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .skipMemoryCache(true)
                .dontAnimate()
//                .error()
//                .placeholder()
    }
}