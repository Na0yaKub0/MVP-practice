package com.example.mvp.data.local

import android.content.Context

class PreferenceManager(context: Context): LocalRepository {

    val sharedPref = context.getSharedPreferences("my_settings", Context.MODE_PRIVATE)

    override fun saveText(text: String) {
        sharedPref.edit().putString("a",text).apply()
    }

    override fun loadText():String {
        return sharedPref.getString("a","初期値")!!
    }

}