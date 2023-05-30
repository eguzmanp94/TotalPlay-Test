package com.legp.totalplaytest.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {
    private val PREFS_NAME = "com.legp.totalplaytest.shared"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)


    fun clearAll() {
        prefs.edit().clear()
    }

    fun logOut() {
        prefs.edit().clear().apply()
        prefs.edit().commit()
    }



    var token: String
        get() = prefs.getString("token", "")!!
        set(value) = prefs.edit().putString("token", value).apply()


}