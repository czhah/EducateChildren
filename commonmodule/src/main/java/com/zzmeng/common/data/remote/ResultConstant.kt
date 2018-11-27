package com.zzmeng.common.data.remote

/** Create by chenzhuang on 2018/11/27 0027 下午 3:29
 *
 */
object ResultConstant {

    //  请求失败
    const val RESULT_FAILED = -1
    //  请求成功
    const val RESULT_SUCCESS = 8000
    //  请求超时
    const val RESULT_TIME_OUT = -2
    //  超出范围
    const val RESULT_OUT_OF_RANGE = 8001
    //  未到达景点
    const val RESULT_OUT_OF_ATTRACTION = 8002
    //  连续操作
    const val RESULT_CONTINUOUSOPERATION = 8003
    //  服务错误
    const val RESULT_SERVICE_FAIL = 9000
    //  记录已存在
    const val RESULT_EXISTS = 9001
    //  记录不存在
    const val RESULT_NOT_EXISTS = 9002
    //  小于
    const val RESULT_LT = 9003
    //  操作失败
    const val RESULT_ACTION_FAIL = 9004
    //  参数不能为空
    const val RESULT_PARAM_EMPTY = 9005
    //  非法参数
    const val RESULT_ILLEGAL_PARAM = 9006
    //  验证失败
    const val RESULT_VALIDATE_FAIL = 9007
    //  未授权
    const val RESULT_NOT_PERMISSION = 9008
    //  小于等于
    const val RESULT_LET = 9009
    //  大于
    const val RESULT_GT = 9010
    //  大于等于
    const val RESULT_GET = 9011
    //  已失效
    const val RESULT_EXPIRED = 9012
    //  翻译失败
    const val RESULT_TRANSLATE_FAIL = 9051
    //  翻译语种错误
    const val RESULT_TRANSLATE_ERROR = 9052
    //  语音识别，说话不标准
    const val RESULT_RECOGNIZE_FAIL = 9053
    //  操作频繁
    const val RESULT_FREQUENTLY = 9100
}