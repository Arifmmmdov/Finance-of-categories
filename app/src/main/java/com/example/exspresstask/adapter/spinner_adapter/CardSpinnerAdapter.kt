package com.example.exspresstask.adapter.spinner_adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.exspresstask.R
import kotlin.coroutines.coroutineContext

class CardSpinnerAdapter(private val context: Context,private val cardIcons:ArrayList<Int>,private val cardNames: ArrayList<String>,private val cardPasswords:ArrayList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return cardIcons.size
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_card_item,p2,false)
        val cardIcon = view.findViewById(R.id.card_icon) as ImageView
        val cardName:TextView = view.findViewById(R.id.card_name)
        val cardPassword:TextView = view.findViewById(R.id.card_password)

        cardIcon.setImageResource(cardIcons[p0])
        cardName.text = cardNames[p0]
        cardPassword.text = cardPasswords[p0]

        return view
    }
}