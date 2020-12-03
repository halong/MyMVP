package com.example.mymvp.ui.main

import android.app.Activity

import com.example.mymvp.base.mvp.BaseView

//View负责视图,由activity实现
interface MainView : BaseView {
    fun showTest(string: String)
}