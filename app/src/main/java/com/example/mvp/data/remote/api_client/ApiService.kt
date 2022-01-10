package com.example.mvp.data.remote.api_client

import com.example.mvp.data.entity.BooksEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("")
    fun getBooks(
        @Query("format") format:String,
        @Query("keyword") keyword:String,
        @Query("booksGenreId") booksGenreId:String,
        @Query("sort") sort:String,
    ): Call<BooksEntity>
}
