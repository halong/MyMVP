package com.example.mymvp.ui.main

import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mymvp.R
import com.example.mymvp.base.BaseActivity
import com.example.mymvp.prefs.PrefsProperty
import com.example.mymvp.databinding.ActivityMainBinding

/**
 * mvp的全称为Model-View-Presenter，Model提供数据，View负责显示，Controller/Presenter负责逻辑的处理。
 * MVP与MVC有着一个重大的区别：在MVP中View并不直接使用Model，
 * 它们之间的通信是通过Presenter (MVC中的Controller)来进行的，所有的交互都发生在Presenter内部，
 * 而在MVC中View会直接从Model中读取数据而不是通过 Controller。
 *
 *
 * Activity需实现View接口，并持有Presenter对象
 *
 * 创建activity：继承BaseActivity<M,V,P>,V
 */

class MainActivity : BaseActivity<MainModel, MainView, MainPresenter>(), MainView {
    private lateinit var binding: ActivityMainBinding //这个类名与布局文件名对应

    //属性委托PrefsProperty，访问时自动从SharedPreferences取值，赋值时自动存入SharedPreferences
    private var t: String by PrefsProperty("t", "hello")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        MainLiveData.observe(this) {
            if (TextUtils.equals(it, FINISH)) {
                finish()
            }
        }
    }

    override fun setPresenter() = MainPresenter()


    private fun initView() {
        val navController: NavController = findNavController(R.id.navHostFragment)
        navController.setGraph(R.navigation.nav_graph)
        //navController每次跳转到的fragment都会重建, 这不合理，需要重写
        navController.navigatorProvider

        binding.bottomNavigation.itemIconTintList = null  //使用menu里的自定义图标
        binding.bottomNavigation.setupWithNavController(navController)
    }

    companion object {
        val MainLiveData = MutableLiveData<String>()

        const val FINISH = "finish"
    }

}