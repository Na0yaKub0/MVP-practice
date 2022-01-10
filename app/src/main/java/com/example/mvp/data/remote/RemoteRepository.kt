package com.example.mvp.data.remote

import com.example.mvp.data.entity.BooksEntity
import retrofit2.Callback
import retrofit2.Response

interface RemoteRepository {

    fun getBooks(word: String, callback: Callback<BooksEntity>)
}