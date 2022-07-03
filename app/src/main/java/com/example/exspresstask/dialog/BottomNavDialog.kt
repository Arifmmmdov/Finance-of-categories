package com.example.exspresstask.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exspresstask.R
import com.example.exspresstask.adapter.SubFrameAdapter
import com.example.exspresstask.databinding.SubDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomNavDialog(
    private val profit:String, private val percentage:String, val icon:Int, private val category:String,
    private val month:String, private val year:String) : BottomSheetDialogFragment() {
    lateinit var binding: SubDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SubDialogBinding.inflate(inflater)
        setBottomDialogViews()
        showRecyclerItems()

        return binding.root
    }

    private fun showRecyclerItems() {
        val adapter = SubFrameAdapter(icon)
        binding.subFrameRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.subFrameRecycler.adapter = adapter
    }

    private fun setBottomDialogViews() {
        binding.subFrameMain.text = category
        binding.date.text = "Expense for $month $year"
        binding.subFrameProfit.text = profit+" AZN"
        binding.subFramePercentage.text = percentage+" of all"
        binding.cornerImage.setImageResource(icon)
    }


}