package com.example.mymvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymvp.base.mvp.BaseModel
import com.example.mymvp.base.mvp.BasePresenter
import com.example.mymvp.base.mvp.BaseView

abstract class BaseActivity<M : BaseModel, V : BaseView, P : BasePresenter<M, V>> :
    AppCompatActivity() {
    //****泛型里面引用其他泛型
    private var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (mPresenter == null)
            mPresenter = setPresenter()
        mPresenter?.bindView(this as V)  //这里强转 实现类必须继承V
    }

    abstract fun setPresenter(): P

    fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.unBindView()
    }

}