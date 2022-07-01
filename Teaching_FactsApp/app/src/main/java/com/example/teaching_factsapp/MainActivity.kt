package com.example.teaching_factsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.homeStartButton)

        startButton.setOnClickListener({
            val intent = Intent(this, FunFact1::class.java)
            startActivity(intent)
        })
    }
}