package com.example.myapplication.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.movies.Movies
import com.example.myapplication.network.movies.MoviesNetwork
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    private val _myResponseList: MutableLiveData<List<Movies>> = MutableLiveData()
    val myResponseList: LiveData<List<Movies>> get() = _myResponseList // Ekspose LiveData

    fun getMovies() {
        // Menjalankan korutin dalam viewModelScope
        viewModelScope.launch {
            try {
                val response = MoviesNetwork.retrofit.getMovies()
                // Memperbarui LiveData dengan data yang didapat
                _myResponseList.value = response.data
            } catch (e: Exception) {
                // Tangani kesalahan di sini
                e.printStackTrace() // Bisa diganti dengan logging yang lebih baik
            }
        }
    }
}