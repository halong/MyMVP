package com.example.mymvp.ui.main

import android.os.Handler
import android.os.Looper
import com.example.mymvp.base.mvp.BaseModel
import com.example.mymvp.bean.Banner
import com.example.mymvp.bean.JsonData
import com.example.mymvp.network.HttpUtils
import com.orhanobut.logger.Logger
import rx.Observer
import java.net.URL

//Model负责数据处理
class MainModel : BaseModel() {

    fun getBaiduHtml(callback: Callback<String>) {
        val mainHandler = Handler(Looper.getMainLooper()) //主线程切换
        Thread {  //子线程
            try {
                val text = URL("https://www.baidu.com").readText()
                Logger.d("hello")
                mainHandler.post {
                    callback.success(text)
                }
            } catch (e: Exception) {
                mainHandler.post {
                    callback.error(e.localizedMessage)
                }
            }
        }.start()
    }


    fun getBanner(callback: Callback<List<Banner>>) {
        HttpUtils.transformThread(HttpUtils.apiService.getBanner())
            .subscribe(object : Observer<JsonData<List<Banner>>> {
                override fun onCompleted() {
                }

                override fun onError(e: Throwable?) {
                    e?.localizedMessage?.let { callback.error(it) }
                }

                override fun onNext(t: JsonData<List<Banner>>?) {
                    t?.data?.let { callback.success(it) }
                }
            })
    }

    interface Callback<T> {
        fun success(data: T)
        fun error(text: String)
    }
}