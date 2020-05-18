package com.example.testmovieapp.ui.adapter

import com.example.testmovieapp.R
import com.example.testmovieapp.data.entity.Movie
import com.example.testmovieapp.databinding.MovieItemBinding
import com.example.testmovieapp.di.ui.BaseRecyclerViewAdapter

class HomeRecylerAdapter : BaseRecyclerViewAdapter<Movie, MovieItemBinding>() {

    /**
     * to get the layout
     */
    override fun getLayout(): Int {
        return R.layout.movie_item
    }

    /**
     * to perform the bind operations
     */
    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<MovieItemBinding>,
        position: Int
    ) {
        holder.binding.movie = items[position]
        //onclick event
        holder.binding.root.setOnClickListener {
            listener?.invoke(it, items[position], position)
        }
    }
}