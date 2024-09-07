package com.example.tugaspam2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumber1 = findViewById<EditText>(R.id.inputNumber1)
        val inputNumber2 = findViewById<EditText>(R.id.inputNumber2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            val num1 = inputNumber1.text.toString().toDoubleOrNull()
            val num2 = inputNumber2.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedOperation = when (radioGroup.checkedRadioButtonId) {
                R.id.radioPlus -> "+"
                R.id.radioMinus -> "-"
                R.id.radioMultiply -> "*"
                R.id.radioDivide -> "/"
                else -> null
            }

            if (selectedOperation == null) {
                Toast.makeText(this, "Pilih operasi yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = when (selectedOperation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else {
                    Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                else -> null
            }

            if (result == null) {
                Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            intent.putExtra("NIM", "225150407111042")
            intent.putExtra("NAMA", "Vincentius Arya Adyatma")
            startActivity(intent)
        }
    }
}