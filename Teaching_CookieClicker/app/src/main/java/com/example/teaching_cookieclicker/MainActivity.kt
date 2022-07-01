package com.example.teaching_cookieclicker

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var image: ImageButton
    private lateinit var clicksLabel: TextView
    private lateinit var clicksCount: TextView
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageButton)
        clicksLabel = findViewById(R.id.clicksLabel)
        clicksCount = findViewById(R.id.clicksCount)
        resetButton = findViewById(R.id.resetButton)

        var count = 0
        image.setOnClickListener() {
            count += 1
            clicksCount.text = count.toString()
        }

        resetButton.setOnClickListener() {
            count = 0
            clicksCount.text = count.toString()
        }
    }
}