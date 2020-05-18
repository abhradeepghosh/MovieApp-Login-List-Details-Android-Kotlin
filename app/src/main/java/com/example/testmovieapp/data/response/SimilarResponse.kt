package com.example.testmovieapp.data.response

import com.example.testmovieapp.data.entity.Movie

data class SimilarResponse(
    val page: Int, // 1
    val results: List<Movie>,
    val total_pages: Int, // 30
    val total_results: Int // 591
)