package com.example.exspresstask.helper

import com.example.exspresstask.R

class CommonHelper {
    companion object{
        fun getChartColors():ArrayList<Int>{
            val colors: ArrayList<Int>  = ArrayList<Int>()
            colors.add(R.color.blue)
            colors.add(R.color.sea)
            colors.add(R.color.red)
            colors.add(R.color.yellow)
            colors.add(R.color.orange)
            return colors
        }
    }
}