package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Kalkulator : AppCompatActivity() {
    private lateinit var displayHasil: TextView
    private var currentInput: String = ""
    private var operator: String = ""
    private var operand1: Int = 0
    private var operand2: Int = 0
    private var result: Int = 0
    private var isNewInput: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        // Inisialisasi TextView dan tombol
        displayHasil = findViewById(R.id.displayHasil)

        // Tombol angka
        val tombol0: Button = findViewById(R.id.tombol0)
        val tombol1: Button = findViewById(R.id.tombol1)
        val tombol2: Button = findViewById(R.id.tombol2)
        val tombol3: Button = findViewById(R.id.tombol3)
        val tombol4: Button = findViewById(R.id.tombol4)
        val tombol5: Button = findViewById(R.id.tombol5)
        val tombol6: Button = findViewById(R.id.tombol6)
        val tombol7: Button = findViewById(R.id.tombol7)
        val tombol8: Button = findViewById(R.id.tombol8)
        val tombol9: Button = findViewById(R.id.tombol9)

        // Tombol operator
        val tombolTambah: Button = findViewById(R.id.tombolTambah)
        val tombolKurang: Button = findViewById(R.id.tombolKurang)
        val tombolKali: Button = findViewById(R.id.tombolKali)
        val tombolBagi: Button = findViewById(R.id.tombolBagi)

        // Tombol lainnya
        val tombolSamaDengan: Button = findViewById(R.id.tombolSamaDengan)
        val tombolC: Button = findViewById(R.id.tombolC)
        val tombolKembali: Button = findViewById(R.id.tombolKembali) // Tombol kembali

        // Set OnClickListener untuk tombol angka
        val angkaClickListener = View.OnClickListener { v ->
            val button = v as Button
            if (isNewInput) {
                currentInput = button.text.toString()
                isNewInput = false
            } else {
                currentInput += button.text.toString()
            }
            displayHasil.text = currentInput
        }

        tombol0.setOnClickListener(angkaClickListener)
        tombol1.setOnClickListener(angkaClickListener)
        tombol2.setOnClickListener(angkaClickListener)
        tombol3.setOnClickListener(angkaClickListener)
        tombol4.setOnClickListener(angkaClickListener)
        tombol5.setOnClickListener(angkaClickListener)
        tombol6.setOnClickListener(angkaClickListener)
        tombol7.setOnClickListener(angkaClickListener)
        tombol8.setOnClickListener(angkaClickListener)
        tombol9.setOnClickListener(angkaClickListener)

        // Set OnClickListener untuk operator
        val operatorClickListener = View.OnClickListener { v ->
            val button = v as Button
            operand1 = currentInput.toInt()
            operator = button.text.toString()
            currentInput = ""
        }

        tombolTambah.setOnClickListener(operatorClickListener)
        tombolKurang.setOnClickListener(operatorClickListener)
        tombolKali.setOnClickListener(operatorClickListener)
        tombolBagi.setOnClickListener(operatorClickListener)

        // Tombol reset
        tombolC.setOnClickListener {
            currentInput = ""
            operand1 = 0
            operator = ""
            displayHasil.text = "0"
            isNewInput = true
        }

        // Tombol sama dengan (perhitungan)
        tombolSamaDengan.setOnClickListener {
            operand2 = currentInput.toInt()
            when (operator) {
                "+" -> result = operand1 + operand2
                "-" -> result = operand1 - operand2
                "*" -> result = operand1 * operand2
                "/" -> result = if (operand2 != 0) operand1 / operand2 else 0
            }

            displayHasil.text = result.toString()
            currentInput = result.toString()
            isNewInput = true
        }

        // Tombol Kembali
        tombolKembali.setOnClickListener {
            // Pindah ke ActivityMain
            Toast.makeText(this, "Menuju Halaman UTAMA", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup activity kalkulator
        }
    }
}