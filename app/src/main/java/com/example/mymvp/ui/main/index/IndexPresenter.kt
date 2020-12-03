package com.example.mymvp.ui.main.index

import com.example.mymvp.base.mvp.BasePresenter

class IndexPresenter : BasePresenter<IndexModel,IndexView>() {
    override fun setModel(): IndexModel = IndexModel()
}