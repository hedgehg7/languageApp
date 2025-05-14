package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LevelActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level2)

        // Ищем кнопки для уровня 1
        val lessonButton1 = findViewById<Button>(R.id.lessonButton2)
        val testButton1 = findViewById<Button>(R.id.testButton2)

        // И так далее для других уровней...

        // Установим обработчики нажатий для уровня 1
        lessonButton1.setOnClickListener {
            val intent = Intent(this, LessonActivity::class.java)
            intent.putExtra("level", 2)  // Передаем уровень 1
            startActivity(intent)
        }

        testButton1.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            intent.putExtra("lessonId", "TestTwo")  // Передаем уровень 1
            startActivity(intent)
        }
    }
}
