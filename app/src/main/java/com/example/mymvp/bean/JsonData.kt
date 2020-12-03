package com.example.mymvp.bean

data class JsonData<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)