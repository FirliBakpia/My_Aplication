package com.example.myapplication.network.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.squareup.picasso.Picasso

internal class MovieAdapter(private var movieList:  List<Movies>) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    internal interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var judul: TextView = view.findViewById(R.id.judul)
//        var rating: TextView = view.findViewById(R.id.rating)
        var deskripsi: TextView = view.findViewById(R.id.deskripsi)
        var sutradara: TextView = view.findViewById(R.id.sutradara)
        var foto: ImageView = view.findViewById(R.id.foto)
        // Tambahkan referensi ke RatingBar dan TextView angka rating
        var ratingBar: RatingBar = view.findViewById(R.id.ratingBar)
        var ratingNumber: TextView = view.findViewById(R.id.rating_number)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.items, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        holder.judul.text = movie.judul
        holder.deskripsi.text = movie.deskripsi
//        holder.rating.text = movie.rating
        holder.sutradara.text = movie.sutradara

        // Set nilai rating ke RatingBar
        holder.ratingBar.rating = movie.rating.toFloat()
        // Set angka rating
        holder.ratingNumber.text = movie.rating
        val url_image = "http://10.0.2.2:5000/" + movie.foto
        Picasso
            .get()
            .load(url_image)
            .resize(650, 850)
            .centerCrop()
            .into(holder.foto)
//        Glide
//            .with(holder.foto.context)
//            .load(movie.foto)
//            .centerCrop()
//            .into(holder.foto);

        // Set OnClickListener untuk item
        holder.itemView.setOnClickListener {
            mListener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}