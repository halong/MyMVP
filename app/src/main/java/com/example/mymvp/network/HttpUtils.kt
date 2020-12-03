package com.example.mymvp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

object HttpUtils {
    private const val baseUrl = "https://www.wanandroid.com/"

    private val client = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()

    /**
     * RxJava：负责网络请求和主线程之间的调度，
     * rxjava的核心功能就是异步，
     * 在这里只是用在了网络请求上，可以开辟新线程，
     * 然后获取数据后在主线程执行，新线程是被观察者，主线程是观察者，
     * 这样就是可以在主线程获取观察到的数据然后进行更新UI
     */
    private val retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(baseUrl)
        .build()

    val apiService = retrofit.create(ApiService::class.java)

    fun <T> transformThread(observable: Observable<T>)=
        observable.subscribeOn(Schedulers.io())//请求数据的事件发生在io线程
            .observeOn(AndroidSchedulers.mainThread())//请求完成后在主线程更显UI

}