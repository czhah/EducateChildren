package com.zzmeng.common.mvp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

open abstract class BaseFragment<P : IPresenter> : Fragment(), IView, IActivity {

    protected var mPresenter: P? = null

    protected var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutId = initContentView()
        try {
            inflater?.inflate(layoutId, container)
            initComponent()
            initData(savedInstanceState)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initTitle(): Int? {
        return null
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
        activity.runOnUiThread { Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show() }
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
        mContext = null
    }

}