package com.example.mvp.main

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp.R
import com.example.mvp.data.local.PreferenceManager
import com.example.mvp.data.remote.api_client.ApiClientManager
import java.net.URL
import kotlin.concurrent.thread


class MainFragment: Fragment(),MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    lateinit var editText :EditText
    lateinit var button :Button
    lateinit var textView :TextView

    lateinit var bookTitleTextView :TextView
    lateinit var bookImageView :ImageView
    lateinit var bookPriceTextView :TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById<EditText>(R.id.editTextText)
        button = view.findViewById<Button>(R.id.button)
        textView = view.findViewById<TextView>(R.id.textView)

        bookTitleTextView = view.findViewById<TextView>(R.id.bookTitleTextView)
        bookImageView = view.findViewById<ImageView>(R.id.bookImageView)
        bookPriceTextView = view.findViewById<TextView>(R.id.bookPriceTextView)

        presenter = MainPresenter(this, PreferenceManager(requireContext()),ApiClientManager())
        
        presenter.start()

        button.setOnClickListener{
            presenter.onClickButton(editText.text.toString())
        }
    }



    override fun showTextView(text: String) {
        textView.text = text
    }

    override fun showBookTitleTextView(text: String) {
        bookTitleTextView.text = text
    }

    override fun showBookPriceTextView(text: String) {
        bookPriceTextView.text = text
    }

    override fun showBookImageView(bitmap: Bitmap) {
        activity?.runOnUiThread {
            bookImageView.setImageBitmap(bitmap)
        }
    }


}