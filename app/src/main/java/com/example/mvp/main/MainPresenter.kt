package com.example.mvp.main




class MainPresenter(private val view: MainContract.View): MainContract.Presenter {
    var rvList = ArrayList<String>()

    //④view.presenter = thisに設定。
    init {
        view.presenter = this
    }

    //⑤追加ボタンが押された時の処理
    override fun onClickAddButton() {
        rvList.add("✖️")
        view.updateRecyclerView(rvList)
    }

    //⑤✖︎ボタンが押された時の処理
    override fun onClickCellDeleteButton(position: Int) {
        rvList.removeAt(position)
        view.updateRecyclerView(rvList)

    }

    //⑤起動時の処理
    override fun start() {
        view.setRecyclerView(rvList)
    }
}