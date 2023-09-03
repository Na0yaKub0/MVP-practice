package com.example.mvp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp.R

class MainActivity : AppCompatActivity(), MainContract.View {

    //②overrideしたContract.presenter(MainContract.Presenter)を追加。
    override lateinit var presenter: MainContract.Presenter
    lateinit var addButton : Button
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.addButton)
        recyclerView = findViewById(R.id.recyclerView)
        initPresenter()
        presenter.start()
        addButton.setOnClickListener {
            presenter.onClickAddButton()
        }
    }

    //③RecyclerViewをセットする
    override fun setRecyclerView(rvList: ArrayList<String>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setPadding(10,20,10,0)
        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager(this).getOrientation())
        getDrawable(R.drawable.divider)?.let { dividerItemDecoration.setDrawable(it) }
        recyclerView.addItemDecoration(dividerItemDecoration)
        var adapter = RvAdapter(this, rvList, applicationContext)
        recyclerView.adapter = adapter
    }

    //③RecyclerViewを更新する
    override fun updateRecyclerView(rvList: ArrayList<String>) {
        var adapter = RvAdapter(this, rvList, applicationContext)
        recyclerView.adapter = adapter
    }

    //③✖︎ボタンが押された時呼び出される
    override fun onClickCellDeleteButton(position: Int) {
        presenter.onClickCellDeleteButton(position)
    }
    fun initPresenter() {
        if (::presenter.isInitialized) {
            return
        }
        presenter = MainPresenter(this)
    }
}