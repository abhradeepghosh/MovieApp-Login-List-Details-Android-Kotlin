package com.example.testmovieapp.service

import com.example.testmovieapp.data.entity.MovieDetail
import com.example.testmovieapp.data.response.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    companion object {
        //movies
        const val NOW_PLAYING_MOVIES = "/3/movie/now_playing"
        const val POPULAR_MOVIES = "/3/movie/popular"
        const val TOP_RATED_MOVIES = "/3/movie/top_rated"
        const val UPCOMING_MOVIES = "/3/movie/upcoming"
        const val MOVIE_DETAILS = "/3/movie/{movie_id}"
        const val SIMILAR_MOVIES = "/3/movie/{movie_id}/similar"
    }

    /**
     * to get the popular movies
     */
    @GET(POPULAR_MOVIES)
    fun getPopularMovies(@Query("api_key") key: String): Observable<MovieResponse>

    /**
     * to get the movie details
     */
    @GET(MOVIE_DETAILS)
    fun getMovieDetail(
        @Path("movie_id") id: String,
        @Query("api_key") key: String
    ): Observable<MovieDetail>

    /**
     * to get the upcoming movie list
     */
    @GET(UPCOMING_MOVIES)
    fun getUpComingMovies(@Query("api_key") key: String): Observable<UpcomingResponse>

    /**
     * to get the top rated movies
     */
    @GET(TOP_RATED_MOVIES)
    fun getTopRatedMovies(@Query("api_key") key: String): Observable<TopRatedResponse>

    /**
     * to get the now playing movies
     */
    @GET(NOW_PLAYING_MOVIES)
    fun getNowPlayingMovies(@Query("api_key") key: String): Observable<NowPlayingResponse>

    /**
     * to get the similar movies
     */
    @GET(SIMILAR_MOVIES)
    fun getSimilarMovies(
        @Path("movie_id") id: String,
        @Query("api_key") key: String
    ): Observable<SimilarResponse>

}