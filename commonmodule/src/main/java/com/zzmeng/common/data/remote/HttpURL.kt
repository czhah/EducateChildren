package com.zzmeng.educatechildren.data.remote

/** Create by chenzhuang on 2018/11/26 0026 下午 5:26
 *
 */
object HttpURL {


    private const val IPPORT = "http://education.smart0.cn"

    private const val PROJECT = "/mono-biz-app/"

    const val BASE_URL = IPPORT + PROJECT

    const val UPLOAD_FILE = BASE_URL + "file/upload.shtml" //上传文件

    const val GET_SENDCODE = BASE_URL + "user/sendCode" //获取验证码
}