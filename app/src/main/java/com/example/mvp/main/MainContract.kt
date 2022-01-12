package com.example.mvp.main

import com.example.mvp.util.BasePresenter
import com.example.mvp.util.BaseView

interface MainContract {

    interface View: BaseView<Presenter> {
        //③textViewをテキストを表示するメソッド
        fun showTextView (text: String)

    }

    interface Presenter: BasePresenter {
        //③Butoonをクリックされた際に使用するメソッド
        fun onClickButton(text: String)

    }
}