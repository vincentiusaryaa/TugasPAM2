package com.example.tugaspam2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val userInfoTextView = findViewById<TextView>(R.id.userInfoTextView)
        val result = intent.getDoubleExtra("RESULT", 0.0)
        val nim = intent.getStringExtra("NIM") ?: "N/A"
        val nama = intent.getStringExtra("NAMA")?: "N/A"

        resultTextView.text = "Hasil : $result"
    }
}
