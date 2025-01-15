package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.network.movies.MovieAdapter
import com.example.myapplication.network.movies.Movies
import com.example.myapplication.ui.screens.MoviesViewModel

class ListMovies : AppCompatActivity() {
    private val TAG = "ListMovies :"
    private val movieList = ArrayList<Movies>()
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movies)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()

        val viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        viewModel.getMovies()
        viewModel.myResponseList.observe(this, Observer { movies ->
            movieAdapter = MovieAdapter(movies)
            recyclerView.adapter = movieAdapter

            // Logging movie details
            for (movie in movies) {
                Log.d(TAG, "ID: ${movie.id}")
                Log.d(TAG, "Judul: ${movie.judul}")
                Log.d(TAG, "Deskripsi: ${movie.deskripsi}")
                Log.d(TAG, "Rating: ${movie.rating}")
                Log.d(TAG, "Foto: ${movie.foto}")
            }

            // Set click listener on "Detail" button for each movie
            movieAdapter.setOnItemClickListener(object : MovieAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val selectedMovie = movies[position]
                    val intent = Intent(this@ListMovies, LoadImageURL::class.java)
                    intent.putExtra("image_url", "http://10.0.2.2:5000/" + selectedMovie.foto) // Mengirim URL gambar ke LoadImageURL Activity
                    startActivity(intent)
                }
            })
        })
    }
}
