package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        // Ищем кнопки для уровня 1
        val lessonButton1 = findViewById<Button>(R.id.lessonButton)
        val testButton1 = findViewById<Button>(R.id.testButton)

        // И так далее для других уровней...

        // Установим обработчики нажатий для уровня 1
        lessonButton1.setOnClickListener {
            val intent = Intent(this, LessonActivity::class.java)
            intent.putExtra("level", 1)  // Передаем уровень 1
            startActivity(intent)
        }

        testButton1.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            intent.putExtra("lessonId", "TestOne")  // Передаем уровень 1
            startActivity(intent)
        }
    }
}
