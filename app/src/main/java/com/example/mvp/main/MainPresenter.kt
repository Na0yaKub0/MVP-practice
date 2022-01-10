package com.example.mvp.main

import android.graphics.BitmapFactory
import com.example.mvp.data.entity.BooksEntity
import com.example.mvp.data.local.LocalRepository
import com.example.mvp.data.remote.RemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URL


class MainPresenter(private val view: MainContract.View, private val localRepository:  LocalRepository, private val remoteRepository: RemoteRepository): MainContract.Presenter {

    //初期化
    init {
        view.presenter = this
    }

    //起動処理
    override fun start() {
        val text =localRepository.loadText()
        view.showTextView(text)
    }

    override fun onClickButton(text: String) {
        localRepository.saveText(text)
        view.showTextView(text)

        remoteRepository.getBooks(text, object: Callback<BooksEntity>{
            override fun onResponse(call: Call<BooksEntity>, response: Response<BooksEntity>) {
                if(response.isSuccessful){
                    response.body()?.Items?.get(0)?.Item?.title?.let {
                        view.showBookTitleTextView(it)
                    }
                    response.body()?.Items?.get(0)?.Item?.largeImageUrl?.let {
                        val url = URL(it)
                        val streem = url.openStream()
                        val bitmap = BitmapFactory.decodeStream(streem)
                        view.showBookImageView(bitmap)
                    }
                    response.body()?.Items?.get(0)?.Item?.itemPrice?.let {
                        view.showBookPriceTextView(it+"円")
                    }

                } else {

                }
            }

            override fun onFailure(call: Call<BooksEntity>, t: Throwable) {
            }

        })
    }

}