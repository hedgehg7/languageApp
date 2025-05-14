package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LevelActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level3)

        // Ищем кнопки для уровня 1
        val lessonButton = findViewById<Button>(R.id.lessonButton3)
        val testButton = findViewById<Button>(R.id.testButton3)

        // И так далее для других уровней...

        // Установим обработчики нажатий для уровня 1
        lessonButton.setOnClickListener {
            val intent = Intent(this, LessonActivity::class.java)
            intent.putExtra("level", 3)  // Передаем уровень 1
            startActivity(intent)
        }

        testButton.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            intent.putExtra("lessonId", "TestThree")  // Передаем уровень 1
            startActivity(intent)
        }
    }
}
