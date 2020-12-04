package com.example.mymvp.ui.main

import com.example.mymvp.base.mvp.BasePresenter
import com.example.mymvp.entity.Banner

//Presenter负责视图与数据之间的逻辑
class MainPresenter : BasePresenter<MainModel,MainView>() {
    fun test() {
        getModel().getBaiduHtml(object : MainModel.Callback<String> {
            override fun success(data: String) {

            }

            override fun error(text: String) {

            }

        })
    }

    fun getBanner(){
        getModel().getBanner(object : MainModel.Callback<List<Banner>> {
            override fun error(text: String) {

            }

            override fun success(data: List<Banner>) {

            }
        })
    }

    override fun setModel() = MainModel()


}