package com.example.mymvp.entity

data class JsonData<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)