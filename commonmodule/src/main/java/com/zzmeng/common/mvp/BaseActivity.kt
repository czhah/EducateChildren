package com.zzmeng.common.mvp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class BaseActivity<IPresenter>(t: com.zzmeng.common.mvp.IPresenter) : AppCompatActivity(), IView, IActivity {

    protected var mPresenter = t
    protected var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        mContext = this

        val layoutId = initContentView()
        try {
            setContentView(layoutId)
            val titleId = initTitle()
            updateTitle(getString(titleId!!))
            initComponent()
            initData(savedInstanceState)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateTitle(title: String?) {

    }

    override fun showLoading() {
    }

    override fun showLoading(resId: Int) {
    }

    override fun showLoading(hint: String) {
    }

    override fun hideLoading() {
    }

    override fun showMessage(message: String) {
        runOnUiThread { Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show() }
    }

    override fun showMessage(resId: Int) {
        showMessage(resources.getString(resId))
    }

    override fun onStart() {
        super.onStart()
        mPresenter?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mPresenter?.onStop()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mPresenter?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDestroy()
        mContext = null
    }
}