package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var gambarDadu: ImageView
    private lateinit var tombolAcak: Button
    private lateinit var tombolUrut: Button
    private lateinit var tombolReset: Button
    private lateinit var tombolListMovie: Button
    private lateinit var tombolKalkulator: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hubungkan dengan ID di XML
        gambarDadu = findViewById(R.id.gambar)
        tombolAcak = findViewById(R.id.tombolGanti)
        tombolUrut = findViewById(R.id.urutDadu)
        tombolReset = findViewById(R.id.tombolReset)
        tombolListMovie = findViewById(R.id.listMovies)
        tombolKalkulator = findViewById(R.id.Kalkulator)

        // Event tombol Acak Dadu
        tombolAcak.setOnClickListener {
            val randomDadu = Random.nextInt(1, 7) // Acak angka 1-6
            val drawableId = when (randomDadu) {
                1 -> R.drawable.dadu1
                2 -> R.drawable.dadu2
                3 -> R.drawable.dadu3
                4 -> R.drawable.dadu4
                5 -> R.drawable.dadu5
                else -> R.drawable.dadu6
            }
            gambarDadu.setImageResource(drawableId)
            Toast.makeText(this, "Dadu menunjukkan angka: $randomDadu", Toast.LENGTH_SHORT).show()
        }


        // Event tombol Pindah ke halaman List Movie
        tombolListMovie.setOnClickListener {
            Toast.makeText(this, "Menuju halaman List Movie", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListMovies::class.java)
            startActivity(intent)
        }

        // Event tombol Pindah ke halaman Kalkulator
        tombolKalkulator.setOnClickListener {
            Toast.makeText(this, "Menuju halaman Kalkulator", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Kalkulator::class.java)
            startActivity(intent)
        }
    }
}