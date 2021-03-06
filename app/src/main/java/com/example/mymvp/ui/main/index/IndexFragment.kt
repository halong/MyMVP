package com.example.mymvp.ui.main.index

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymvp.R
import com.example.mymvp.base.BaseFragment
import com.example.mymvp.databinding.FragmentIndexBinding
import com.orhanobut.logger.Logger


class IndexFragment : BaseFragment<IndexModel, IndexView, IndexPresenter>(), IndexView {
    private lateinit var binding: FragmentIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Logger.d("hello")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIndexBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun setPresent() = IndexPresenter()
}