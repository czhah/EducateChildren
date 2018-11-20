package com.zzmeng.educatechildren.presenter

import com.zzmeng.common.mvp.BasePresenter
import com.zzmeng.educatechildren.contract.MainContract

class MainPresenter(mModel: MainContract.Model?, mView: MainContract.View?) : BasePresenter<MainContract.Model, MainContract.View>(mModel, mView), MainContract.Presenter
