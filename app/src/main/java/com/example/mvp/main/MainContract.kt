package com.example.mvp.main

import android.graphics.Bitmap
import com.example.mvp.util.BasePresenter
import com.example.mvp.util.BaseView

interface MainContract {

    interface View: BaseView<Presenter> {
        fun showTextView (text: String)

        //①bookTitleTextViewに本のタイトルを表示させるメソッド
        fun showBookTitleTextView (text: String)
        //①bookPriceTextViewに値段を表示させるメソッド
        fun showBookPriceTextView (text: String)
        //①bookImageViewに画像を表示させるメソッド
        fun showBookImageView (bitmap: Bitmap)
    }

    interface Presenter: BasePresenter {
        fun onClickButton(text: String)
    }
}