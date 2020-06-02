package com.example.gitjesup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class NewAdapter: RecyclerView.Adapter<ViewHolder>(){

    private val listNew = mutableListOf<NewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listNew.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNew[position])
    }

    fun set(list: MutableList<NewModel>){
        this.listNew.clear()
        this.listNew.addAll(list)
        notifyDataSetChanged()
    }

}