package com.example.mymvp.database

import com.example.mymvp.App

object SQLiteUtils {
    private const val DB_NAME = "default.db"
    private const val DB_VERSION = 1
    val mSQLiteOpenHelper: MySQLiteOpenHelper by lazy {
        MySQLiteOpenHelper(App.getInstance(), DB_NAME, DB_VERSION)
    }

}