package com.zzmeng.common.util

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/** Create by chenzhuang on 2018/11/27 0027 下午 8:15
 *
 */
object ObservableUtils {
    /**
     * RXJAVA
     *
     * @param callback    回调
     * @param onSubscribe onSubscribe
     * @param <T>         泛型
     * @return Disposable
    </T> */
    fun <T> handle(callback: BaseDataCallback<T>, onSubscribe: ObservableOnSubscribe<T>): Disposable {
        return Observable
                .create(onSubscribe)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t ->
                    callback.onSuccess(t)
                    callback.onFinish()
                }) { throwable ->
                    callback.onFail(throwable.toString())
                    callback.onFinish()
                }
    }
}