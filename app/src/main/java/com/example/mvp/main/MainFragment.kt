package com.example.mvp.main
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.mvp.R


class MainFragment : Fragment(), MainContract.Fragment {

    ////⑤overrideしたContract.presenter(MainContract.Presenter)を追加。
    override lateinit var presenter: MainContract.Presenter

    lateinit var fragmentTextView :TextView
    lateinit var fragmentButton :Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTextView = view.findViewById(R.id.fragmentTextView)
        fragmentButton = view.findViewById(R.id.fragmentButton)
        //④fragmentを親Viewに渡す。
        activity?.let {
            if (it is MainActivity) {
                it.initPresenter(this)
            }
        }

        fragmentButton.setOnClickListener {
            //⑦presenter.onClickFragmentButtonを呼び出す。
            presenter.onClickFragmentButton()
        }
    }

    //⑥FragmentTextViewに文字を表示させる
    override fun showFragmentTextView(text: String) {
        fragmentTextView.text = text
    }
}