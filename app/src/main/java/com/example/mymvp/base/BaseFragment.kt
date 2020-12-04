package com.example.mymvp.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mymvp.base.mvp.BaseModel
import com.example.mymvp.base.mvp.BasePresenter
import com.example.mymvp.base.mvp.BaseView

abstract class BaseFragment<M : BaseModel, V : BaseView, P : BasePresenter<M, V>> : Fragment() {
    private lateinit var mPresenter: P

    @Suppress("UNCHECKED_CAST")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = setPresent()
        mPresenter.bindView(this as V)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.unBindView()
    }

    abstract fun setPresent(): P
}