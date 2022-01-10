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

    //Retrofitクラスのインスタンス化
    val retrofit = Retrofit.Builder()
        //ベースURLを入力
        .baseUrl("https://app.rakuten.co.jp/services/api/BooksTotal/Search/")
        //レスポンスを変換する設定を追加
        .addConverterFactory(GsonConverterFactory.create())
        //Httpクライアント結合
        .client(getOkHttpClient())
        //onResponseバックグラウンド処理
        .callbackExecutor(Executors.newSingleThreadExecutor())
        .build()

    // サービスクラスの実装オブジェクト取得(インターフェイスを利用する)
    val apiClient:ApiService = retrofit.create(ApiService::class.java)

    private fun getOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()
        return httpClient
    }


    override fun getBooks(word: String, callback: Callback<BooksEntity>) {
        apiClient.getBooks(format = "json", keyword = word, booksGenreId = "000", sort = "standard").enqueue(callback)
    }

}