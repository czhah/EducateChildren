package com.zzmeng.common.util

import com.zzmeng.common.BaseApplication

/** Create by chenzhuang on 2018/11/27 0027 下午 8:16
 *
 */
open abstract class BaseDataCallback<in T> {

    /**
     * 获取数据成功
     *
     * @param result 结果
     */
    abstract fun onSuccess(result: T)

    /**
     * 失败时调用
     *
     * @param errMsg 错误信息 默认土司提示
     */
    fun onFail(errMsg: String) {
        ToastUtils.showToast(BaseApplication.INSTANCE!!.applicationContext, errMsg)
    }

    /**
     * 成功失败都调用 成功时主动调用
     */
    abstract fun onFinish()
}