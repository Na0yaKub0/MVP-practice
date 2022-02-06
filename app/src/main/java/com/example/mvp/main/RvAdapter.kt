package com.example.mvp.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp.R

class RvAdapter(private val litner: MainContract.View,
                private val List: ArrayList<String>,
                private val context: Context): RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cellDeleteButton: TextView

        init{
            cellDeleteButton  = view.findViewById<TextView>(R.id.cellDeleteButton)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cell, parent, false)
        view.layoutParams.height= 150
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
        holder.cellDeleteButton.setOnClickListener {
            //③view側に渡すpositionを渡すメソッド
            litner.onClickCellDeleteButton(position)
        }
    }

    override fun getItemCount(): Int {
        return List.size
    }
}