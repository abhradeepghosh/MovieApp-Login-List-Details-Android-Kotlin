package com.example.testmovieapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testmovieapp.data.entity.Movie
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface MovieDao {
    /**
     * to insert movies into db
     */
    @Insert
    fun saveMovie(movie: Movie): Completable

    /**
     * to get movies from db
     */
    @Query("SELECT * FROM Movie")
    fun getMovies(): Flowable<List<Movie>>
}