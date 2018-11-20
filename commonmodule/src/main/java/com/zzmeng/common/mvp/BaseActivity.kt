package com.zzmeng.common.mvp

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

open abstract class BaseActivity<P : IPresenter> : AppCompatActivity(), IView, IActivity {

    protected var mPresenter: P? = null

    protected var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        mContext = this
        Log.i("cz", "onCreate:")
        val layoutId = initContentView()
        try {
            Log.i("cz", "setContentView:")
            setContentView(layoutId)
            val titleId = initTitle()
            updateTitle(getString(titleId!!))
            initComponent()
            initData(savedInstanceState)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("cz", "error:" + e.toString())
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

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.onDestroy()
        mPresenter = null
        mContext = null
    }
}