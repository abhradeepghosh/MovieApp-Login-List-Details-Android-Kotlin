package com.example.testmovieapp.repository.detail


import com.example.testmovieapp.data.entity.MovieDetail
import com.example.testmovieapp.data.response.SimilarResponse
import com.example.testmovieapp.service.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class DetailRepository @Inject constructor(val service: ApiService) {

    /**
     * to get the movies by id
     */
    fun getMovieById(id: String, key: String): Observable<MovieDetail> {
        return service.getMovieDetail(id, key)
    }

    /**
     * to get the similar movies
     */
    fun getSimilarMovies(id: String, key: String): Observable<SimilarResponse> {
        return service.getSimilarMovies(id, key)
    }
}