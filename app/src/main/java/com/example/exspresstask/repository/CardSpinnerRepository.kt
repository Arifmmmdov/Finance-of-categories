package com.example.exspresstask.repository

import com.example.exspresstask.R

class CardSpinnerRepository {
    companion object{
        fun getCardIcons():ArrayList<Int>{
            val list = ArrayList<Int>()
            list.add(R.drawable.card)
            list.add(R.drawable.card)
            list.add(R.drawable.card)
            list.add(R.drawable.card)
            return list
        }

        fun getCardNames():ArrayList<String>{
            val names = ArrayList<String>()
            names.add("First MC")
            names.add("Second MC")
            names.add("Third MC")
            names.add("Fourth MC")
            return names
        }

        fun getCardNos():ArrayList<String>{
            val numbers = ArrayList<String>()
            numbers.add("** 4554")
            numbers.add("** 2324")
            numbers.add("** 2866")
            numbers.add("** 8987")
            return numbers
        }
    }
}