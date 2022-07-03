package com.example.exspresstask

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exspresstask.databinding.ActivityMainBinding
import com.example.exspresstask.dialog.BottomNavDialog
import com.example.exspresstask.helper.CommonHelper
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate


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
        setupPieCharts()
        setPieChartData()
    }

    private fun setPieChartData() {
        val pieData: ArrayList<PieEntry> = ArrayList<PieEntry>()
        pieData.add(PieEntry(0.10f,"First"))
        pieData.add(PieEntry(0.10f,"Second"))
        pieData.add(PieEntry(0.08f,"Third"))
        pieData.add(PieEntry(0.12f,"Fourth"))
        pieData.add(PieEntry(0.26f,"Fifth"))
        pieData.add(PieEntry(0.34f,"Sixth"))

        val colors:ArrayList<Int> = ArrayList<Int>()

        for(color in ColorTemplate.MATERIAL_COLORS){
            colors.add(color)
        }

        for(color in ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color)
        }

        val pieDataSet = PieDataSet(pieData,"DataSetWithPieChart")
        pieDataSet.colors = colors


        val data = PieData(pieDataSet)
        data.setDrawValues(false)
        data.setValueFormatter(PercentFormatter(binding.pieChart))
        data.setValueTextSize(10f)
        data.setValueTextColor(Color.BLACK)

        binding.pieChart.data = data
        binding.pieChart.invalidate()

        binding.pieChart.animateY(1400, Easing.EaseInOutQuad)



    }

    private fun setupPieCharts() {
        binding.pieChart.isDrawHoleEnabled = true;
        binding.pieChart.setDrawCenterText(true)
        binding.pieChart.holeRadius = 80f
        binding.pieChart.setUsePercentValues(false);
        binding.pieChart.setEntryLabelTextSize(5f);
        binding.pieChart.setEntryLabelColor(Color.BLACK);
        binding.pieChart.centerText = "Spending by Category";
        binding.pieChart.setCenterTextSize(2f);
        binding.pieChart.description.isEnabled = false;
        binding.pieChart.legend.isEnabled = false


//        val l: Legend = binding.pieChart.legend
//        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
//        l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
//        l.orientation = Legend.LegendOrientation.HORIZONTAL
//        l.setDrawInside(true)
//        l.isEnabled = false
    }

    private fun setListeners() {

    }

}