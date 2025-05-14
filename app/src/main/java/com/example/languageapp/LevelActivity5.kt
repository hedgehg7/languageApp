package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LevelActivity5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level5)

        // Ищем кнопки для уровня 1
        val lessonButton1 = findViewById<Button>(R.id.lessonButton5)
        val testButton1 = findViewById<Button>(R.id.testButton5)

        // И так далее для других уровней...

        // Установим обработчики нажатий для уровня 1
        lessonButton1.setOnClickListener {
            val intent = Intent(this, LessonActivity::class.java)
            intent.putExtra("level", 5)  // Передаем уровень 1
            startActivity(intent)
        }

        testButton1.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            intent.putExtra("lessonId", "TestFive")  // Передаем уровень 1
            startActivity(intent)
        }
    }
}
