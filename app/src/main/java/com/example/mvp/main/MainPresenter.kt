package com.example.mvp.main




class MainPresenter(private val activity: MainContract.Activity,
                    private val fragment: MainContract.Fragment): MainContract.Presenter {

    //数字をカウントする変数
    var cnt = 0

    //初期化
    init {
        //⑤activity.presenter = thisに設定。
        activity.presenter = this
        //⑥fragment.presenter = thisに設定。
        fragment.presenter = this
    }

    //⑦Activity側のボタンが押された時の処理
    override fun onClickActivityButton() {
        cnt += 1
        activity.showActivityTextView(cnt.toString())
        fragment.showFragmentTextView(cnt.toString())
    }
    //⑦Fragment側のボタンが押された時の処理
    override fun onClickFragmentButton() {
        cnt += 10
        activity.showActivityTextView(cnt.toString())
        fragment.showFragmentTextView(cnt.toString())
    }

    override fun start() {
    }
}