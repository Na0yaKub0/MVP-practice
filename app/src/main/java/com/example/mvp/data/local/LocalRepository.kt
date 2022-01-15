package com.example.mvp.data.local

interface LocalRepository {

    //②テキストを保存するメソッド
    fun saveText(text: String)

    //②テキストを読み込むメソッド
    fun loadText():String

}