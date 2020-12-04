package com.example.mymvp.prefs

import android.annotation.SuppressLint
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PrefsProperty<T>(val name: String, private val default: T) :   // name指的是键名
    ReadWriteProperty<Any?, T> {    //自定义属性委托的关键是继承 ReadWriteProperty

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getValue(name, default)   //参数不要管，给出返值就行
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putValue(name, value)      //这个value是属性赋值时传入的值
    }

    /**
     * 根据键名从SharedPreferences取值
     */
    @Suppress("UNCHECKED_CAST")
    fun <T> getValue(name: String, default: T): T = with(PrefsUtils.prefs) {
        val res: Any = when (default) {
            is Int -> getInt(name, default)
            is Long -> getLong(name, default)
            is Float -> getFloat(name, default)
            is String -> getString(name, default)!!
            is Boolean -> getBoolean(name, default)
            else -> PrefsUtils.deSerialization(getString(name, PrefsUtils.serialize(default)))
        }
        return res as T
    }

    /**
     * 根据键名往SharedPreferences存值
     */
    @SuppressLint("CommitPrefEdits")
    private fun <T> putValue(name: String, value: T) = with(PrefsUtils.prefs.edit()) {
       //with(t:T,block: T() -> R)
        when (value) {
            is Int -> putInt(name, value)
            is Long -> putLong(name, value)
            is Float -> putFloat(name, value)
            is String -> putString(name, value)
            is Boolean -> putBoolean(name, value)
            else -> putString(name, PrefsUtils.serialize(value))
        }.apply()
    }




}