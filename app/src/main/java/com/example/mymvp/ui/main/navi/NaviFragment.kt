package com.example.mymvp.ui.main.navi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymvp.R
import com.example.mymvp.base.BaseFragment


class NaviFragment : BaseFragment<NaviModel,NaviView,NaviPresenter>(),NaviView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navi, container, false)
    }

    override fun setPresent()=NaviPresenter()
}