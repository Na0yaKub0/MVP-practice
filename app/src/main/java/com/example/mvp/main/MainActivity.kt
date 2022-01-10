package com.example.mvp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transition = supportFragmentManager.beginTransaction()
        transition.add(R.id.mainActivityLayout, MainFragment())
        transition.commit()
    }
}