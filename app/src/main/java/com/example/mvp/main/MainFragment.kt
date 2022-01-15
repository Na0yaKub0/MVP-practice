package com.example.mvp.main


import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.mvp.R
import com.example.mvp.data.local.PreferenceManager


class MainFragment: Fragment(),MainContract.View {

    override lateinit var presenter: MainContract.Presenter
    lateinit var editText :EditText
    lateinit var button :Button
    lateinit var textView :TextView

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

        //①Presenterに引数にpreferenceManagerを追加
        presenter = MainPresenter(this, PreferenceManager(requireContext()))
        
        presenter.start()

        button.setOnClickListener{
            presenter.onClickButton(editText.text.toString())
        }
    }
    override fun showTextView(text: String) {
        textView.text = text
    }
}