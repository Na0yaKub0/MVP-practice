package com.example.mvp.main

import android.graphics.Bitmap
import com.example.mvp.util.BasePresenter
import com.example.mvp.util.BaseView

interface MainContract {

    interface Activity: BaseView<Presenter> {
        //③Activity側のTextViewをテキストを表示するメソッド
        fun showActivityTextView (text: String)
    }

    interface Fragment: BaseView<Presenter> {
        //③Fragment側のTextViewをテキストを表示するメソッド
        fun showFragmentTextView (text: String)

    }

    interface Presenter: BasePresenter {
        //③Activity側のButoonをクリックされた際に使用するメソッド
        fun onClickActivityButton ()
        //③Fragment側のButoonをクリックされた際に使用するメソッド
        fun onClickFragmentButton ()
    }
}