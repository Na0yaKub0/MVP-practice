package com.example.mvp.data.local

import android.content.Context

class PreferenceManager(context: Context): LocalRepository {

    //⑤SharedPreferenceインスタンス化。
    val sharedPref = context.getSharedPreferences("my_settings", Context.MODE_PRIVATE)

    //⑥文字を保存する処理
    override fun saveText(text: String) {
        sharedPref.edit().putString("a",text).apply()
    }

    //⑥文字を読み出す処理
    override fun loadText():String {
        return sharedPref.getString("a","初期値")!!
    }

}