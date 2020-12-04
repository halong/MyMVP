package com.example.mymvp.ui.main.navi

import com.example.mymvp.base.mvp.BasePresenter

class NaviPresenter : BasePresenter<NaviModel, NaviView>() {
    override fun setModel() = NaviModel()
}