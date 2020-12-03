package com.example.mymvp.ui.main

import com.example.mymvp.base.mvp.BasePresenter
import com.example.mymvp.bean.Banner

//Presenter负责视图与数据之间的逻辑
class MainPresenter : BasePresenter<MainView, MainModel>() {
    fun test() {
        getModel().getBaiduHtml(object : MainModel.Callback<String> {
            override fun success(data: String) {
                getView()?.showTest(data)
            }

            override fun error(text: String) {
                getView()?.showTest(text)
            }

        })
    }

    fun getBanner(){
        getModel().getBanner(object : MainModel.Callback<List<Banner>> {
            override fun error(text: String) {
                getView()?.showTest(text)
            }

            override fun success(data: List<Banner>) {
                getView()?.showTest(data.toString())
            }
        })
    }

    override fun setModel() = MainModel()


}