package com.example.exspresstask.repository

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.exspresstask.R
import kotlin.coroutines.coroutineContext

open class MainDataRepository {
    companion object{
        fun getCatTexts():ArrayList<String>{
            val catTexts = ArrayList<String>()
            catTexts.add("Airlines")
            catTexts.add("Rent A Car")
            catTexts.add("Hotels And Motels")
            catTexts.add("Transport")
            catTexts.add("Cars And Vehicles")
            catTexts.add("Government Services")
            catTexts.add("Personal Services")
            catTexts.add("Professional Services")
            catTexts.add("Business Services")
            catTexts.add("Repair Services")
            catTexts.add("Clothing Store")
            catTexts.add("Sale By Mail Or Telephone")
            return catTexts
        }

        fun getIcons(context: Context):ArrayList<Int>{
            val icons = ArrayList<Int>()
            icons.add( R.drawable.airlines)
            icons.add(R.drawable.ic_rent_a_car)
            icons.add( R.drawable.ic_hotels_motels)
            icons.add( R.drawable.ic_transport)
            icons.add( R.drawable.ic_cars_vehicles)
            icons.add( R.drawable.ic_government_services)
            icons.add( R.drawable.ic_personal_services)
            icons.add( R.drawable.ic_professional_services)
            icons.add( R.drawable.ic_business_services)
            icons.add( R.drawable.ic_repair_services)
            icons.add( R.drawable.ic_clothing_store)
            icons.add( R.drawable.ic_sale_by_mail_or_phone)

            return icons
        }

        fun getProfits():ArrayList<String>{
            val profits = ArrayList<String>()

            profits.add("1 500")
            profits.add("3 000")
            profits.add("4 500")
            profits.add("1 200")
            profits.add("3 000")
            profits.add("9 000")
            profits.add("1 000")
            profits.add("1 000")
            profits.add("3 000")
            profits.add("6 700")
            profits.add("2 500")
            profits.add("500")

            return profits
        }


    }

}