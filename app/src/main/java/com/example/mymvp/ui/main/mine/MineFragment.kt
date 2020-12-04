package com.example.mymvp.ui.main.mine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymvp.R
import com.example.mymvp.base.BaseFragment


class MineFragment : BaseFragment<MineModel, MineView, MinePresenter>(), MineView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    override fun setPresent() = MinePresenter()

}