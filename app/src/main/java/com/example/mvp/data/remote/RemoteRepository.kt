package com.example.mvp.data.remote

import com.example.mvp.data.entity.BooksEntity
import retrofit2.Callback
import retrofit2.Response

interface RemoteRepository {

    //④本を検索しデータを持ってくる。
    fun getBooks(word: String, callback: Callback<BooksEntity>)
}