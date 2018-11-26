package com.zzmeng.educatechildren.data.remote

import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

/** Create by chenzhuang on 2018/11/26 0026 下午 5:32
 *
 */
interface IRetrofitApi {

    @POST
    fun postJson(@Url url: String, @Body body: RequestBody): Observable<ResponseBody> // 提交json数据

    @Multipart
    @POST(HttpURL.UPLOAD_FILE)
    fun postFile(@Part("parameter") description: RequestBody, @Part filePart: MultipartBody.Part): Observable<ResponseBody> // 上传文件

    @POST
    fun postMultiFile(@Url url: String, @Body requestBody: RequestBody): Observable<ResponseBody> // 上传文件
}