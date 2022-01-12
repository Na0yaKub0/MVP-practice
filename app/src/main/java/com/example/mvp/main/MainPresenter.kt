package com.example.mvp.main


//②Contract.View(MainContract.View)を引数に導入。
//③Contract.presenter(MainContract.Presenter)を戻り値に導入。
class MainPresenter(private val view: MainContract.View): MainContract.Presenter {


    //④view.presenter = thisに設定
    init {
        view.presenter = this
    }

    //⑤起動処理
    override fun start() {
    }

    //⑤ボタンが押された時の処理
    override fun onClickButton(text: String) {
        view.showTextView(text)
    }

}