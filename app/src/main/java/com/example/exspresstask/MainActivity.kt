package com.example.exspresstask

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.ContentInfo
import android.view.View
import android.widget.Button
import com.example.exspresstask.databinding.ActivityMainBinding
import com.example.exspresstask.dialog.BottomNavDialog
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavDialog: BottomNavDialog
    lateinit var btn_showDialog: Button



    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        btn_showDialog = findViewById(R.id.showDialog)
        bottomNavDialog = BottomNavDialog()
        setListeners()
    }

    private fun setListeners() {
        btn_showDialog.setOnClickListener{
            bottomNavDialog.show(supportFragmentManager,"exampleBottomSheet")
        }
    }
}