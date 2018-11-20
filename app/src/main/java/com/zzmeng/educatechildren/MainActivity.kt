package com.zzmeng.educatechildren

import android.os.Bundle
import android.util.Log
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

        ImageOptions.OPTIONS.placeholder(-100).build()

        Log.i("cz", "placeHolder:" + ImageOptions.OPTIONS.getLoadingRes())
    }
}
