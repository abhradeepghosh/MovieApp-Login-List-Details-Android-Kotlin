package com.example.testmovieapp.data.response

import com.example.testmovieapp.data.entity.Movie

data class TopRatedResponse(
    val page: Int, // 1
    val results: List<Movie>,
    val total_pages: Int, // 358
    val total_results: Int // 7151
)