package com.example.testmovieapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testmovieapp.data.dao.MovieDao
import com.example.testmovieapp.data.entity.Movie


@Database(entities = [Movie::class], version = AppDb.VERSION, exportSchema = true)
abstract class AppDb : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun movieDao(): MovieDao
}