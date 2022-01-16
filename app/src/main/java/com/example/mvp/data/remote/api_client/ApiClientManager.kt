package com.example.mvp.data.remote.api_client

import com.example.mvp.data.entity.BooksEntity
import com.example.mvp.data.remote.RemoteRepository
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ApiClientManager: RemoteRepository {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://app.rakuten.co.jp/services/api/BooksTotal/Search/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(getOkHttpClient())
        .callbackExecutor(Executors.newSingleThreadExecutor())
        .build()
    val apiClient:ApiService = retrofit.create(ApiService::class.java)

    private fun getOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()
        return httpClient
    }

    //⑥本を検索するメソッド
    override fun getBooks(word: String, callback: Callback<BooksEntity>) {
        apiClient.getBooks(format = "json", keyword = word, booksGenreId = "000", sort = "standard").enqueue(callback)
    }
}