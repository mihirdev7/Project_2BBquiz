package com.example.quizapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Pie
import com.anychart.enums.LegendLayout

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val anyChartView: AnyChartView = findViewById(R.id.anyChartView)

        val correctAnswers = intent.getIntExtra("correctAnswers", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 1)
        val incorrectAnswers = intent.getIntExtra("incorrectAnswers", 0)

        val pie: Pie = AnyChart.pie()

        val data = listOf(
            ValueDataEntry("Correct", correctAnswers),
            ValueDataEntry("Incorrect", incorrectAnswers)
        )
        pie.data(data)

        pie.legend()
            .position("center")
            .itemsLayout(LegendLayout.HORIZONTAL)
            .align("center")

        anyChartView.setChart(pie)
    }
}
