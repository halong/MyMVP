package com.example.mymvp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymvp.R
import com.example.mymvp.databinding.ActivityLoginBinding
import com.example.mymvp.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        MainActivity.MainLiveData.value=MainActivity.FINISH
    }
}