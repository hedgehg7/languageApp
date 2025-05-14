package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.languageapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val level1 = findViewById<Button>(R.id.level1)
        val level2 = findViewById<Button>(R.id.level2)
        val level3 = findViewById<Button>(R.id.level3)
        val level4 = findViewById<Button>(R.id.level4)
        val level5 = findViewById<Button>(R.id.level5)

        // Сначала разблокируем только Level 1
        level1.isEnabled = true
        level2.isEnabled = true
        level3.isEnabled = true
        level4.isEnabled = true
        level5.isEnabled = true

        val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val level2Unlocked = sharedPreferences.getBoolean("level2Unlocked", false)


        level1.setOnClickListener {
            val intent = Intent(this, LevelActivity::class.java)
            intent.putExtra("level", 1) // Передаем уровень
            startActivity(intent)
        }
        level2.setOnClickListener {
            val intent = Intent(this, LevelActivity2::class.java)
            intent.putExtra("level", 2) // Передаем уровень
            startActivity(intent)
        }
        level3.setOnClickListener {
            val intent = Intent(this, LevelActivity3::class.java)
            intent.putExtra("level", 3) // Передаем уровень
            startActivity(intent)
        }
        level4.setOnClickListener {
            val intent = Intent(this, LevelActivity4::class.java)
            intent.putExtra("level", 4) // Передаем уровень
            startActivity(intent)
        }
        level5.setOnClickListener {
            val intent = Intent(this, LevelActivity5::class.java)
            intent.putExtra("level", 5) // Передаем уровень
            startActivity(intent)
        }
        val musicLearningButton = findViewById<Button>(R.id.musicLearningButton)
        musicLearningButton.setOnClickListener {
            val intent = Intent(this, MusicLearningActivity::class.java)
            startActivity(intent)
        }
    }
}
