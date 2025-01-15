package com.example.myapplication.network.movies

import retrofit2.http.GET

interface MoviesApi {
    @GET("api/movies")
    suspend fun getMovies(): ResponseMovies
}