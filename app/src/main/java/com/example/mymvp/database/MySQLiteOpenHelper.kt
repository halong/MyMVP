package com.example.mymvp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLiteOpenHelper(
    context: Context,
    name: String,
    version: Int
) :
    SQLiteOpenHelper(context, name, null, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "create table if not exists student(" +
                    "id integer primary key autoincrement," +
                    "name text not null," +
                    "age integer)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}