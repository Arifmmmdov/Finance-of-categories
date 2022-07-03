package com.example.exspresstask.adapter

import android.content.res.Resources
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exspresstask.R

class SubFrameAdapter(private val setIcon: Int): RecyclerView.Adapter<SubFrameAdapter.ViewHolder>() {


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val subIcon:ImageView = itemView.findViewById(R.id.subIcon)
//        val subCenterText:TextView = itemView.findViewById(R.id.subCenterText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyc_item_sub,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.subIcon.setBackgroundResource(setIcon)
    }

    override fun getItemCount(): Int {
        return 20
    }
}