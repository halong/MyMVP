package com.example.mymvp.ui.main.index

import com.example.mymvp.base.mvp.BasePresenter

class IndexPresenter : BasePresenter<IndexView, IndexModel>() {
    override fun setModel(): IndexModel = IndexModel()
}