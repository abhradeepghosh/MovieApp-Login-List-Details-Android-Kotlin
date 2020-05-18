package com.example.testmovieapp.service

import com.example.testmovieapp.data.entity.MovieDetail
import com.example.testmovieapp.data.response.*
import com.example.testmovieapp.util.annotations.Tmdb
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiService @Inject constructor(@Tmdb retrofit: Retrofit) : ApiClient {
    private val api by lazy {
        retrofit.create(ApiClient::class.java)
    }

    /**
     * to direct the getPopularMovies call to the client
     */
    override fun getPopularMovies(key: String): Observable<MovieResponse> {
        return api.getPopularMovies(key)
    }

    /**
     * to direct the getMovieDetail call to the client
     */
    override fun getMovieDetail(id: String, key: String): Observable<MovieDetail> {
        return api.getMovieDetail(id, key)
    }

    /**
     * to direct the upcoming movies call to the client
     */
    override fun getUpComingMovies(key: String): Observable<UpcomingResponse> {
        return api.getUpComingMovies(key)
    }

    /**
     * to direct the top rated movies call to the client
     */
    override fun getTopRatedMovies(key: String): Observable<TopRatedResponse> {
        return api.getTopRatedMovies(key)
    }

    /**
     * to direct the now playing movies call to the client
     */
    override fun getNowPlayingMovies(key: String): Observable<NowPlayingResponse> {
        return api.getNowPlayingMovies(key)
    }

    /**
     * to direct the similar movies call to the client
     */
    override fun getSimilarMovies(id: String, key: String): Observable<SimilarResponse> {
        return api.getSimilarMovies(id, key)
    }

}