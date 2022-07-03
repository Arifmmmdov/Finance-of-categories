package com.example.exspresstask

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exspresstask.adapter.MainFrameAdapter
import com.example.exspresstask.adapter.spinner_adapter.CardSpinnerAdapter
import com.example.exspresstask.databinding.ActivityMainBinding
import com.example.exspresstask.dialog.BottomNavDialog
import com.example.exspresstask.event.OnItemClickedEvent
import com.example.exspresstask.repository.CardSpinnerRepository
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
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
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
        sharedPreferences = getSharedPreferences("SharedData", Context.MODE_PRIVATE)

        setContentView(binding.root)

        setViews()
        setupPieCharts()
    }

    private fun setViews() {
        setListeners()
        setSpinners()
        showRecyclerView()
    }

    private fun setListeners() {
        binding.month.onItemSelectedListener(this)
        binding.year.onItemSelectedListener(this)
        binding.creditCard.onItemSelectedListener(this)

        binding.pieChartViewStatement.setOnClickListener{
            val bottomNavDialog = BottomNavDialog(binding.pieChartProfit.text.toString(),binding.pieChartPercentage.text.toString(),sharedPreferences.getInt("Icon",R.drawable.airlines),binding.pieChartCategory.text.toString(),binding.month.selectedItem.toString(),binding.year.selectedItem.toString())
            bottomNavDialog.show(supportFragmentManager,"OnViewStatementClicked")
        }
    }

    private fun setSpinners() {
        binding.creditCard.adapter = CardSpinnerAdapter(this,CardSpinnerRepository.getCardIcons(),CardSpinnerRepository.getCardNames(),CardSpinnerRepository.getCardNos())
        binding.month.adapter = ArrayAdapter.createFromResource(this,R.array.month,android.R.layout.simple_list_item_1)
        binding.year.adapter = ArrayAdapter.createFromResource(this,R.array.year,android.R.layout.simple_list_item_1)


    }


    private fun showRecyclerView() {
        R.drawable.airlines
        val adapter = MainFrameAdapter(MainDataRepository.getIcons(),MainDataRepository.getCatTexts(),MainDataRepository.getProfits())
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
        binding.pieChart.animateY(1400, Easing.EaseInOutQuad)



    }

    private fun setupPieCharts() {
        binding.pieChart.isDrawHoleEnabled = true
        binding.pieChart.holeRadius = 80f
        binding.pieChart.setUsePercentValues(false)
        binding.pieChart.setEntryLabelTextSize(5f)
        binding.pieChart.setEntryLabelColor(Color.BLACK)
        binding.pieChart.setCenterTextSize(25f)
        binding.pieChart.setDrawEntryLabels(false)
        binding.pieChart.description.isEnabled = false
        binding.pieChart.legend.isEnabled = false


        setPieChartData()

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    fun onItemClicked(onItemClicked: OnItemClickedEvent){
        setPieChartTexts(onItemClicked)
        callBottomNavigationDialog(onItemClicked)
        rememberIcon(onItemClicked.icon)
    }

    private fun callBottomNavigationDialog(onItemClicked: OnItemClickedEvent) {
        val bottomNavDialog = BottomNavDialog(onItemClicked.profit,onItemClicked.percentage,onItemClicked.icon,onItemClicked.category,binding.month.selectedItem.toString(),binding.year.selectedItem.toString())
        bottomNavDialog.show(supportFragmentManager,"bottomNavigationDialog")
    }

    private fun setPieChartTexts(onItemClicked: OnItemClickedEvent) {
        binding.pieChartProfit.text = onItemClicked.profit
        binding.pieChartPercentage.text = onItemClicked.percentage
        binding.pieChartCategory.text = onItemClicked.category
    }

    private fun Spinner.onItemSelectedListener(mainActivity: MainActivity) {
        this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val dec = DecimalFormat("###,###,###")
                binding.expencesValue.text = dec.format(Random.nextInt(1000000,1500000)).toString()
                binding.incomingsValue.text = dec.format(Random.nextInt(1500000,2000000)).toString()
                binding.cashbackValue.text = dec.format(Random.nextInt(100000,100500)).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun rememberIcon(icon:Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("Icon",icon)
        editor.apply()
    }
}






