package com.example.teaching_percentagecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.SeekBar
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var numberLabel: TextView
    private lateinit var numberInput: EditText
    private lateinit var percentageLabel: TextView
    private lateinit var percentageNumber: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var resultLabel: TextView
    private lateinit var resultNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberLabel = findViewById(R.id.numberLabel)
        numberInput = findViewById(R.id.numberInput)
        percentageLabel = findViewById(R.id.percentageLabel)
        percentageNumber = findViewById(R.id.percentageNumber)
        seekBar = findViewById(R.id.seekBar)
        resultLabel = findViewById(R.id.resultLabel)
        resultNumber = findViewById(R.id.resultNumber)

        percentageNumber.text = "0"

        // SeekBar
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                percentageNumber.text = p1.toString() + "%"
                calculatePercentage()
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        // Edit Text
        numberInput.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                calculatePercentage()
            }
        })
    }

    private fun calculatePercentage() {
        var number: Double = 0.0

        if( numberInput.text.trim().isNotEmpty() ) {
            number = numberInput.text.toString().toDouble()
        }

        var percentage = seekBar.progress
        var result = number * percentage / 100

        resultNumber.text = result.toString()
    }
}