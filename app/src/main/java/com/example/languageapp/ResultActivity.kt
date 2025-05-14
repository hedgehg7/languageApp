package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultImage = findViewById<ImageView>(R.id.resultImage)
        val resultText = findViewById<TextView>(R.id.resultText)
        val backToLevels = findViewById<Button>(R.id.backToLevels)

        val correctCount = intent.getIntExtra("correctCount", 0)

        if (correctCount >= 10) {
            resultImage.setImageResource(R.drawable.success_image)
            resultText.text = "You did great!"
        } else {
            resultImage.setImageResource(R.drawable.failure_image)
            resultText.text = "Don't worry, try again!"
        }

        backToLevels.setOnClickListener { v: View? ->
            val intent = Intent(
                this@ResultActivity,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }
}
