package com.example.testmovieapp.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.testmovieapp.App
import com.example.testmovieapp.data.AppDb
import com.example.testmovieapp.data.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {

    /**
     * provides the room database builder
     */
    @Singleton
    @Provides
    fun providesRoomDatabase(application: Application): AppDb {
        return Room.databaseBuilder(application, AppDb::class.java, "movie.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    /**
     * provides the movie dao
     */
    @Provides
    fun providesMovieDao(appDb: AppDb): MovieDao {
        return appDb.movieDao()
    }
}