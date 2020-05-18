package com.example.testmovieapp.service

import com.example.testmovieapp.data.dao.MovieDao
import com.example.testmovieapp.data.entity.Movie
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class DatabaseService @Inject constructor(private val movieDao: MovieDao) {

    /**
     * to handle the save movies into db
     */
    fun saveMovies(movie: Movie): Completable {
        return movieDao.saveMovie(movie)
    }

    /**
     * to handle the get movies from db
     */
    fun getMovies(): Flowable<List<Movie>> {
        return movieDao.getMovies()
    }
}