package com.example.mymvp.ui.main

import android.app.Activity
import android.os.Bundle
import com.example.mymvp.base.BaseActivity
import com.example.mymvp.databinding.ActivityMainBinding

/**
 * mvp的全称为Model-View-Presenter，Model提供数据，View负责显示，Controller/Presenter负责逻辑的处理。
 * MVP与MVC有着一个重大的区别：在MVP中View并不直接使用Model，
 * 它们之间的通信是通过Presenter (MVC中的Controller)来进行的，所有的交互都发生在Presenter内部，
 * 而在MVC中View会直接从Model中读取数据而不是通过 Controller。
 *
 *
 * Activity实现View接口，并持有Presenter对象
 */

class MainActivity : BaseActivity<MainView,MainModel,MainPresenter>(), MainView {
    private lateinit var binding: ActivityMainBinding //这个类名与布局文件名对应
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    override fun setPresenter() = MainPresenter()

    private fun initView() {
        binding.tv.setOnClickListener {
            getPresenter()?.test()
        }
    }

    override fun showTest(string: String) {
        binding.tv.text = string
    }
}