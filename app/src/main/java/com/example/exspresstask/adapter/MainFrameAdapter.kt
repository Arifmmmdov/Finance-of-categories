package com.example.exspresstask.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exspresstask.R
import com.example.exspresstask.event.OnItemClickedEvent
import org.greenrobot.eventbus.EventBus

class MainFrameAdapter(private val icons:ArrayList<Int>, private val categories:ArrayList<String>, private val profits:ArrayList<String>) : RecyclerView.Adapter<MainFrameAdapter.ViewHolder>() {


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val icon:ImageView = itemView.findViewById(R.id.cat_icon)
        val mainText:TextView = itemView.findViewById(R.id.cat_text)
        val profit:TextView = itemView.findViewById(R.id.AZN)
        val percentage:TextView = itemView.findViewById(R.id.percentage)
        val mainRecycItem:RelativeLayout = itemView.findViewById(R.id.mainRecycItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.recyc_item_main,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.icon.setBackgroundResource(icons[position])
        holder.mainText.text = categories[position]
        holder.profit.text = profits[position]+" AZN"
        holder.percentage.text = "20%"
        holder.mainRecycItem.setOnClickListener {
            EventBus.getDefault().postSticky(OnItemClickedEvent(profits[position],holder.percentage.text.toString(),icons[position], categories[position]))
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}