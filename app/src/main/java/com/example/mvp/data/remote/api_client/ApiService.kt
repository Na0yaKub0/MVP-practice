package com.example.mvp.data.remote.api_client

import com.example.mvp.data.entity.BooksEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("")
    //"https://app.rakuten.co.jp/services/api/BooksTotal/Search/20170404?applicationId=1083451209915038351&format=json&keyword="+serch+"&booksGenreId=000&sort=standard"
    //URLで&の部分を記載する。
    fun getBooks(
        @Query("format") format:String,
        @Query("keyword") keyword:String,
        @Query("booksGenreId") booksGenreId:String,
        @Query("sort") sort:String,
    ): Call<BooksEntity>
}