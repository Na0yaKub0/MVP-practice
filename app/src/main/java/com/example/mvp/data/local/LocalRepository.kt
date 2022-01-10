package com.example.mvp.data.local

interface LocalRepository {

    fun saveText(text: String)

    fun loadText():String

}