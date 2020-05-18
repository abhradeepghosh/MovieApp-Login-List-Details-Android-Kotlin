package com.example.testmovieapp.data.response

import com.example.testmovieapp.data.entity.Movie

data class MovieResponse(
    val page: Int, // 1
    val results: List<Movie>,
    val total_pages: Int, // 500
    val total_results: Int // 10000
)