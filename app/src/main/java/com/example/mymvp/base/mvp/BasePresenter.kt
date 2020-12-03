package com.example.mymvp.base.mvp

abstract class BasePresenter<V : BaseView, M : BaseModel> {
    private var mView: V? = null
    private val mModel = setModel()

    abstract fun setModel(): M

    fun getModel() = mModel

    fun bindView(view: V) {
        mView = view
    }

    fun unBindView() {
        mView = null
    }

    fun getView() = mView
}