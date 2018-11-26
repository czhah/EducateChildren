package com.zzmeng.educatechildren

import android.os.Bundle
import com.bumptech.glide.Glide
import com.zzmeng.common.manager.image.ImageOptions
import com.zzmeng.common.mvp.BaseActivity
import com.zzmeng.educatechildren.contract.MainContract
import com.zzmeng.educatechildren.model.MainModel
import com.zzmeng.educatechildren.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainContract.View {
    override fun add() {
    }

    override fun initContentView(): Int {
        return R.layout.activity_main
    }

    override fun initTitle(): Int? {
        return 0
    }

    override fun initComponent() {
        mPresenter = MainPresenter(MainModel(), this)

        tv_text.text = "haha"
    }

    override fun initData(savedInstanceState: Bundle?) {

        val options = ImageOptions.getInstance().placeholder(-100).build()
        val img_path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542821162273&di=41490b9a9d95ab800a150fb58b446bd2&imgtype=0&src=http%3A%2F%2Fwx3.sinaimg.cn%2Fmw690%2F79ad09d9gy1fnqgdmnsxbj20iy0sgtao.jpg"
//        ImageManager.INSTANCE.load(this, iv_bitmap, img_path)

        Glide.with(this).load(img_path).into(iv_bitmap)
//        ImageManager.INSTANCE.load(this, img_path, ImageOptions.getInstance().build(), object: IDownloadListener{
//            override fun downloadFailed() {
//                Log.i("cz", "加载失败")
//            }
//
//            override fun downloadSuccess(bitmap: Bitmap) {
//                iv_bitmap.setImageBitmap(bitmap)
//            }
//
//        })
    }
}
