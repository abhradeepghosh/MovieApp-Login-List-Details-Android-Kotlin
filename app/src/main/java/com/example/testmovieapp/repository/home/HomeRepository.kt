package com.example.testmovieapp.repository.home

import com.example.testmovieapp.data.response.MovieResponse
import com.example.testmovieapp.data.response.NowPlayingResponse
import com.example.testmovieapp.data.response.TopRatedResponse
import com.example.testmovieapp.data.response.UpcomingResponse
import com.example.testmovieapp.service.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val service: ApiService
) {

    /**
     * to get the popular movies
     */
    fun getPopularMovies(key: String): Observable<MovieResponse> {
        return service.getPopularMovies(key)
    }

    /**
     * to get the now playing movies
     */
    fun getNowPlaying(key: String): Observable<NowPlayingResponse> {
        return service.getNowPlayingMovies(key)
    }

    /**
     * to get the top rated movies
     */
    fun getTopRated(key: String): Observable<TopRatedResponse> {
        return service.getTopRatedMovies(key)
    }

    /**
     * to get the upcoming movies
     */
    fun getUpComing(key: String): Observable<UpcomingResponse> {
        return service.getUpComingMovies(key)
    }

    /**
     * this can be leveraged while doing the db operations
     */
//    fun saveMovieToDb(movie: Movie): Completable {
//        return databaseService.saveMovies(movie)
//    }
//
//    fun getMovieFromDb(): Flowable<List<Movie>> {
//        return databaseService.getMovies()
//    }
}