package com.example.mvp.main

import android.graphics.Bitmap
import com.example.mvp.util.BasePresenter
import com.example.mvp.util.BaseView

interface MainContract {

    interface View: BaseView<Presenter> {

        fun showTextView (text: String)

        fun showBookTitleTextView (text: String)

        fun showBookPriceTextView (text: String)

        fun showBookImageView (bitmap: Bitmap)

    }

    interface Presenter: BasePresenter {

        fun onClickButton(text: String)

    }
}