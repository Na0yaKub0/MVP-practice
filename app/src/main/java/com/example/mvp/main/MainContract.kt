package com.example.mvp.main

import android.graphics.Bitmap
import com.example.mvp.util.BasePresenter
import com.example.mvp.util.BaseView

interface MainContract {

    interface RecyclerView {
        //③✖︎ボタンクリックされた際にview側に渡すメソッド
        fun onClickCellDeleteButton (position: Int)
    }

    interface View: BaseView<Presenter> {
        //③RecyclerViewを初期化するメソッド
        fun setRecyclerView (rvList: ArrayList<String>)
        //③RecyclerViewを更新するメソッド
        fun updateRecyclerView (rvList: ArrayList<String>)
    }

    interface Presenter: BasePresenter {
        //③Activity側のaddButoonをクリックされた際に使用するメソッド
        fun onClickAddButton ()
        //③RecyclerViewの✖︎Butoonをクリックされた際に使用するメソッド
        fun onClickCellDeleteButton (position: Int)
    }
}