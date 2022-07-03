package com.example.exspresstask.repository

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


    }

}