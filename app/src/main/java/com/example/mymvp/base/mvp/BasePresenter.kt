package com.example.mymvp.base.mvp

abstract class BasePresenter<M : BaseModel, V : BaseView> {
    private var mView: V? = null
    private var mModel: M? = null

    abstract fun setModel(): M

    fun getModel(): M {
        if (mModel == null) {
            mModel = setModel()
        }
        return mModel!!
    }

    fun bindView(view: V) {
        mView = view
    }

    fun unBindView() {
        mView = null
    }

    fun getView() = mView
}