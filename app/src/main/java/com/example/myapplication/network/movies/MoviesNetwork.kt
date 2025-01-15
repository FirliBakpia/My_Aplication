package com.example.myapplication.network.movies

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesNetwork {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi::class.java)
    }
//    val service: MoviesApi by lazy {
//        retrofit.create(MoviesApi::class.java)
//    }
}