package com.example.exspresstask

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exspresstask.adapter.MainFrameAdapter
import com.example.exspresstask.databinding.ActivityMainBinding
import com.example.exspresstask.dialog.BottomNavDialog
import com.example.exspresstask.event.OnItemClickedEvent
import com.example.exspresstask.repository.MainDataRepository
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val TAG="MyTagHere"


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setListeners()
        setupPieCharts()
        setPieChartData()
        showRecyclerAdapters();
    }

    private fun showRecyclerAdapters() {
        R.drawable.airlines
        val adapter = MainFrameAdapter(MainDataRepository.getIcons(this),MainDataRepository.getCatTexts(),MainDataRepository.getProfits())
        binding.mainRecyc.adapter = adapter
        binding.mainRecyc.layoutManager = LinearLayoutManager(this)
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
        binding.pieChart.addView(LayoutInflater.from(this).inflate(R.layout.inside_piechart,null))
        binding.pieChart.invalidate()

        binding.pieChart.animateY(1400, Easing.EaseInOutQuad)



    }

    private fun setupPieCharts() {
        binding.pieChart.isDrawHoleEnabled = true
        binding.pieChart.setDrawCenterText(true)
        binding.pieChart.holeRadius = 80f
        binding.pieChart.setUsePercentValues(false)
        binding.pieChart.setEntryLabelTextSize(5f)
        binding.pieChart.setEntryLabelColor(Color.BLACK)
        binding.pieChart.setCenterTextSize(2f)
        binding.pieChart.description.isEnabled = false
        binding.pieChart.legend.isEnabled = false

    }

    private fun setListeners() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    fun onItemClicked(onItemClicked: OnItemClickedEvent){
        val bottomNavDialog = BottomNavDialog(onItemClicked.profit,onItemClicked.percentage,onItemClicked.icon,onItemClicked.category,binding.month.toString(),binding.year.toString())
        bottomNavDialog.show(supportFragmentManager,"bottomNavigationDialog")
    }

}