package com.example.exspresstask.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exspresstask.databinding.TransportDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomNavDialog : BottomSheetDialogFragment() {
    lateinit var binding: TransportDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TransportDialogBinding.inflate(inflater)
        return binding.root
    }


}