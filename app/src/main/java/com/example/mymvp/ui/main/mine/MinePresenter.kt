package com.example.mymvp.ui.main.mine

import com.example.mymvp.base.mvp.BasePresenter

class MinePresenter : BasePresenter<MineModel, MineView>() {
    override fun setModel(): MineModel = MineModel()
}