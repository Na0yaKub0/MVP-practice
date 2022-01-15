package com.example.mvp.main

import android.graphics.BitmapFactory
import com.example.mvp.data.entity.BooksEntity
import com.example.mvp.data.local.LocalRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URL


class MainPresenter(private val view: MainContract.View, private val localRepository:  LocalRepository): MainContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        //②文字を呼び出す処理
        val text =localRepository.loadText()
        view.showTextView(text)
    }

    override fun onClickButton(text: String) {
        //②文字を保存する処理
        localRepository.saveText(text)
        view.showTextView(text)
    }
}