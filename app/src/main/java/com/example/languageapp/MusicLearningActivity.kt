package com.example.languageapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MusicLearningActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var lyricsTextView: TextView
    private lateinit var playButton: Button
    private lateinit var showWordsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_learning)

        playButton = findViewById(R.id.playButton)
        showWordsButton = findViewById(R.id.showWordsButton)
        lyricsTextView = findViewById(R.id.lyricsTextView)

        mediaPlayer = MediaPlayer.create(this, R.raw.adel_hello)
        mediaPlayer = MediaPlayer.create(this, R.raw.avicii_wake_me_up)
        mediaPlayer = MediaPlayer.create(this, R.raw.bruno_mars_just_the_way_you_are)
        mediaPlayer = MediaPlayer.create(this, R.raw.dua_lipa_new_rules)

        playButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                playButton.text = "Play"
            } else {
                mediaPlayer.start()
                playButton.text = "Pause"
            }
        }

        showWordsButton.setOnClickListener {
            lyricsTextView.text = """
                🔑 Useful Phrases:
                - I'm feeling good – Я чувствую себя хорошо
                - Let's go – Погнали
                - All night long – Всю ночь напролёт
            """.trimIndent()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
