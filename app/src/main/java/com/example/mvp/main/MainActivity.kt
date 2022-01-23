package com.example.mvp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mvp.R

class MainActivity : AppCompatActivity(), MainContract.Activity {

    //②overrideしたContract.presenter(MainContract.Presenter)を追加。
    override lateinit var presenter: MainContract.Presenter

    lateinit var activityTextView : TextView
    lateinit var activityButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //③Fragment設定(引数に自分を入れる)。
        val transition = supportFragmentManager.beginTransaction()
        transition.add(R.id.fragmentLayout, MainFragment(this))
        transition.commit()


        activityTextView = findViewById(R.id.activityTextView)
        activityButton = findViewById(R.id.activityButton)

        activityButton.setOnClickListener {
            //⑤presenter.onClickActivityButtonを呼び出す。
            presenter.onClickActivityButton()
        }
    }
    //④ActivityTextViewに文字を表示させる
    override fun showActivityTextView(text: String) {
        activityTextView.text = text
    }
}