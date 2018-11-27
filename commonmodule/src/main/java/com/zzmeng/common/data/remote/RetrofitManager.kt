package com.zzmeng.educatechildren.data.remote

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.google.gson.Gson
import com.zzmeng.common.BaseApplication
import com.zzmeng.educatechildren.data.local.DatabaseConstant
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/** Create by chenzhuang on 2018/11/26 0026 下午 5:32
 *
 */
object RetrofitManager {

    private var INSTANCE: Retrofit? = null

    //  临时超时时间 10s
    private var TEMP_OUT_TIME = 10000L
    //  超时时间
    private const val OUT_TIME = 10000L
    //  缓存大小
    private const val NETWORK_CACHE_SIZE = 10 * 1024 * 1024L

    //  文件格式
    val TYPE_FILE = MediaType.parse("multipart/form-data")
    //  文本格式
    val TYPE_JSON = MediaType.parse("application/json; charset=utf-8")

    private val lock = Any()

    private val cacheControlInterceptor = Interceptor { chain ->
        var request = chain.request()

        if (DatabaseConstant.isConnectedByState(BaseApplication.INSTANCE?.applicationContext!!)) {
            //  没有网络 读取缓存
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
        }
        val originalResponse = chain.proceed(request)
        if (DatabaseConstant.isConnectedByState(BaseApplication.INSTANCE?.applicationContext!!)) {
            //  有网络时 设置缓存
            val maxAge = 0 // read from cache
            originalResponse.newBuilder()
                    .header("Cache-Control", "public ,max-age=$maxAge")
                    .removeHeader("Pragma")
                    //                        .body(new ProgressResponseBody(originalResponse.body()))
                    .build()
        } else {
            //  没有网络时 直接读取缓存
            val maxStale = 60 * 60 * 24
            originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                    .removeHeader("Pragma")
                    .build()
        }
    }

    fun getInstance(): Retrofit {
        synchronized(lock){
            if(INSTANCE == null) {
                var cacheDir = File(BaseApplication.INSTANCE?.cacheDir, "retrofit")

                val cache = Cache(cacheDir, NETWORK_CACHE_SIZE)

                val cookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(BaseApplication.INSTANCE))
                val builder = OkHttpClient.Builder()
                        .cache(cache)
                        .cookieJar(cookieJar)
                        .addInterceptor(cacheControlInterceptor)
                        .connectTimeout(OUT_TIME, TimeUnit.MILLISECONDS)
                        .readTimeout(OUT_TIME, TimeUnit.MILLISECONDS)
                        .writeTimeout(OUT_TIME, TimeUnit.MILLISECONDS)
                        .retryOnConnectionFailure(true)//  失败重连

                openDebug(builder)

                INSTANCE = Retrofit.Builder()
                        .baseUrl(HttpURL.BASE_URL)
                        .client(builder.build())
                        .addConverterFactory(GsonConverterFactory.create(Gson()))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()

            }
        }
        return INSTANCE!!
    }

    private fun openDebug(builder: OkHttpClient.Builder) {
        //  测试包打开日志
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)
    }

}