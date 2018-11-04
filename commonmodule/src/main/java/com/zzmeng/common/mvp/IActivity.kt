package com.zzmeng.common.mvp

import android.os.Bundle

interface IActivity {

    fun initContentView(): Int

    fun initTitle(): Int?

    fun initComponent()

    fun initData(savedInstanceState: Bundle?)

}