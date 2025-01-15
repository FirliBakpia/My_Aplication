package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class LoadImageURL : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_image_url)

        val imageView: ImageView = findViewById(R.id.imageView)
        val imageUrl = intent.getStringExtra("image_url") // Menerima data URL dari Intent

        if (imageUrl != null && imageUrl.isNotEmpty()) {
            // Memuat gambar menggunakan Picasso
            Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.wait) // Gambar sementara jika sedang memuat
                .error(R.drawable.error_image) // Gambar error jika gagal memuat
                .into(imageView)
        }
    }
}