package com.lllddd.todayfriedbreadstick.http

import com.lllddd.todayfriedbreadstick.base.Constants.BASE_URL
import com.lllddd.todayfriedbreadstick.base.Constants.BASE_URL_TEST
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * author: lllddd
 * created on: 2023/6/23 17:40
 * description:Http Utils object声明代表该类中的方法与常量都是静态的
 */
object HttpUtils {
    private var mOkHttpClient: OkHttpClient? = null

    /**
     * Check whether is test environment, then return the related url
     *
     * @param isTest Whether is test environment
     */
    private fun isTest(isTest: Boolean): String = if (isTest) BASE_URL_TEST else BASE_URL

    /**
     * Create API object
     *
     * @param clazz class declaration
     */
    fun <T> createApi(clazz: Class<T>): T =
        Retrofit.Builder()
            .baseUrl(isTest(true))
            .client(getClient()!!)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(clazz)

    /**
     * Get client
     */
    private fun getClient(): OkHttpClient? {
        if (mOkHttpClient == null) {
            mOkHttpClient = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
        }

        return mOkHttpClient
    }

    /**
     * Get interceptor
     */
    private fun getInterceptor(): Interceptor {
        HttpLoggingInterceptor.Logger {
            Logger.json(it)
        }

        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    fun <T : Any> sendHttp(ob: Observable<T>, listener: ResponseListener<T>?) {
        ob.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<T> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    listener?.onFail(e.message.toString())
                }

                override fun onComplete() {
                }

                override fun onNext(t: T) {
                    listener?.onSuccess(t)
                }
            })
    }
}