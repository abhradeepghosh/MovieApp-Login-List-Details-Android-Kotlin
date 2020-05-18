package com.example.testmovieapp.di.modules

import com.example.testmovieapp.BuildConfig
import com.example.testmovieapp.util.BASE_URL
import com.example.testmovieapp.util.annotations.Tmdb
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class ApiModule {
    //using annotations to distinguish between various base urls
    @Provides
    @Singleton
    @Tmdb
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createClient()!!)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun createClient(): OkHttpClient? {
        val okHttpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor: HttpLoggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        //okHttpClientBuilder.addInterceptor(CustomInterceptor())
        return okHttpClientBuilder.build()
    }


}