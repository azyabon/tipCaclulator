package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tipPercent = findViewById(R.id.textView6) as TextView
        val tipCount = findViewById(R.id.textView4) as TextView
        val totalCount = findViewById(R.id.textView5) as TextView
        val slider = findViewById(R.id.seekBar) as SeekBar
        val amount = findViewById(R.id.editTextNumberDecimal) as EditText


        fun calculate() {
            if (amount.text.isEmpty()) {
                return
            }
            val calcTip = amount.text.toString().toDouble() / 100 * slider.progress.toDouble()
            val calcTotal = amount.text.toString().toDouble() + calcTip
            tipCount.text = String.format("%.2f", calcTip)
            totalCount.text = String.format("%.2f", calcTotal)
        }

        slider?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                tipPercent.text = slider.progress.toString() + "%"
                calculate()
            }
            override fun onStartTrackingTouch(seek: SeekBar) {}
            override fun onStopTrackingTouch(seek: SeekBar) {}
        })

        amount.setOnClickListener() {
            calculate()
        }
    }
}
