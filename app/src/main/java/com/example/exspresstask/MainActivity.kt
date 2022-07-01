package com.example.exspresstask

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.exspresstask.databinding.ActivityMainBinding
import com.example.exspresstask.dialog.BottomNavDialog

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavDialog: BottomNavDialog
    lateinit var binding: ActivityMainBinding
    val TAG="MyTagHere"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNavDialog = BottomNavDialog()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.showDialog.setOnClickListener{
            bottomNavDialog.show(supportFragmentManager,"bottomNavigationDialog")
        }
    }

}