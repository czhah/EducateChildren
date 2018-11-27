package com.zzmeng.common.util

import android.content.Context
import android.widget.Toast
import com.zzmeng.common.R
import com.zzmeng.common.data.remote.ResultConstant

/** Create by chenzhuang on 2018/11/27 0027 下午 2:35
 *      Toast帮助类
 */
object ToastUtils {

    private var mToast: Toast? = null

    private fun makeText(context: Context, text: String) {
        if(mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        } else {
            mToast!!.setText(text)
        }
        mToast!!.show()
    }

    fun showToast(context: Context, resId: Int) {
        showToast(context, context.getString(resId))
    }

    fun showToast(context: Context, content: String) {
        makeText(context, content)
    }

    fun showResult(context: Context, error: Int) {
        showToast(context, getErrorText(context, error))
    }

    private fun getErrorText(context: Context, error: Int): String {
        val tip: Int
        when (error) {
            ResultConstant.RESULT_FAILED -> tip = R.string.error_request_0
            ResultConstant.RESULT_TIME_OUT -> tip = R.string.error_network
            ResultConstant.RESULT_OUT_OF_RANGE -> tip = R.string.error_request_8001
            ResultConstant.RESULT_OUT_OF_ATTRACTION -> tip = R.string.error_request_8002
            ResultConstant.RESULT_CONTINUOUSOPERATION -> tip = R.string.error_request_8003
            ResultConstant.RESULT_SERVICE_FAIL -> tip = R.string.error_request_9000
            ResultConstant.RESULT_EXISTS -> tip = R.string.error_request_9001
            ResultConstant.RESULT_NOT_EXISTS -> tip = R.string.error_request_9002
            ResultConstant.RESULT_LT -> tip = R.string.error_request_9003
            ResultConstant.RESULT_ACTION_FAIL -> tip = R.string.error_request_9004
            ResultConstant.RESULT_PARAM_EMPTY -> tip = R.string.error_request_9005
            ResultConstant.RESULT_ILLEGAL_PARAM -> tip = R.string.error_request_9006
            ResultConstant.RESULT_VALIDATE_FAIL -> tip = R.string.error_request_9007
            ResultConstant.RESULT_NOT_PERMISSION -> tip = R.string.error_request_9008
            ResultConstant.RESULT_LET -> tip = R.string.error_request_9009
            ResultConstant.RESULT_GT -> tip = R.string.error_request_9010
            ResultConstant.RESULT_GET -> tip = R.string.error_request_9011
            ResultConstant.RESULT_EXPIRED -> tip = R.string.error_request_9012
            ResultConstant.RESULT_TRANSLATE_FAIL -> tip = R.string.error_request_9051
            ResultConstant.RESULT_TRANSLATE_ERROR -> tip = R.string.error_request_9052
            ResultConstant.RESULT_RECOGNIZE_FAIL -> tip = R.string.error_request_9053
            ResultConstant.RESULT_FREQUENTLY -> tip = R.string.error_request_9100
            else -> tip = R.string.error_request_0
        }
        return context.getString(tip)
    }
}