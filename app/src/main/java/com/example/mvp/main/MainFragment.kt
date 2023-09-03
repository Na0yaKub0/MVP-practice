package com.example.mvp.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mvp.R



class MainFragment: Fragment(),MainContract.View {
    //②overrideしたContract.presenter(MainContract.Presenter)を導入。
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

        //③起動時にpresenterをインスタンス化
        initPresenter()
        //⑤presenter.startを呼び出す。
        presenter.start()
        button.setOnClickListener{
            //⑤presenter.onClickButtonを呼び出す。
            presenter.onClickButton(editText.text.toString())
        }
    }
    //④TextViewに文字を表示させる
    override fun showTextView(text: String) {
        textView.text = text
    }

    fun initPresenter() {
        if (::presenter.isInitialized) {
            return
        }
        presenter = MainPresenter(this)
    }
}