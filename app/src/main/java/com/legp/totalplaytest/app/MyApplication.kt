package com.legp.totalplaytest.app

import android.app.Application
import com.legp.totalplaytest.utils.SharedPreferences

val preferences: SharedPreferences by lazy { MyApplication.prefs!! }
class MyApplication : Application() {

    companion object {
        var prefs: SharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()

        prefs = SharedPreferences(applicationContext)
    }

}