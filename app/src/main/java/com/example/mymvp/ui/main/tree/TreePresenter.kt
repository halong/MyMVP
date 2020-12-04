package com.example.mymvp.ui.main.tree

import com.example.mymvp.base.mvp.BasePresenter

class TreePresenter : BasePresenter<TreeModel, TreeView>() {
    override fun setModel() = TreeModel()
}