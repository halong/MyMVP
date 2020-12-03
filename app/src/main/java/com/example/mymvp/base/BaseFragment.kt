package com.example.mymvp.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mymvp.base.mvp.BaseModel
import com.example.mymvp.base.mvp.BasePresenter
import com.example.mymvp.base.mvp.BaseView

abstract class BaseFragment<M : BaseModel, V : BaseView, P : BasePresenter<M, V>> : Fragment() {
    private lateinit var mPresenter: P
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = setPresent()
        mPresenter.bindView(this as V)
    }


    abstract fun setPresent(): P

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unBindView()
    }
}