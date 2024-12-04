package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton: Button = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {

            val correctAnswers = listOf(true, false, true, false, true)

            val userAnswers = listOf(
                findViewById<RadioGroup>(R.id.question1Group).checkedRadioButtonId == R.id.question1True,
                findViewById<RadioGroup>(R.id.question2Group).checkedRadioButtonId == R.id.question2True,
                findViewById<RadioGroup>(R.id.question3Group).checkedRadioButtonId == R.id.question3True,
                findViewById<RadioGroup>(R.id.question4Group).checkedRadioButtonId == R.id.question4True,
                findViewById<RadioGroup>(R.id.question5Group).checkedRadioButtonId == R.id.question5True
            )

            val numberOfCorrectAnswers = userAnswers.zip(correctAnswers).count { it.first == it.second }
            val totalQuestions = 5
            val incorrectAnswers = totalQuestions - numberOfCorrectAnswers

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("correctAnswers", numberOfCorrectAnswers)
                putExtra("totalQuestions", totalQuestions)
                putExtra("incorrectAnswers", incorrectAnswers)
            }
            startActivity(intent)
        }
    }
}
