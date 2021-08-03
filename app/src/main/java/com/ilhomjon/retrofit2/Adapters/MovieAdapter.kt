package com.ilhomjon.retrofit2.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilhomjon.retrofit2.Models.Movie
import com.ilhomjon.retrofit2.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso

class MovieAdapter(val listMoview:List<Movie>) : RecyclerView.Adapter<MovieAdapter.Vh>(){
    inner class Vh(var itemRv: ItemMovieBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(movie: Movie){
            itemRv.nameTv.text = movie.name
            Picasso.get().load(movie.imageurl).into(itemRv.imageItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(listMoview[position])
    }

    override fun getItemCount(): Int = listMoview.size
}