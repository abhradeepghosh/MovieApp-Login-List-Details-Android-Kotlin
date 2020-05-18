package com.example.testmovieapp.ui.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testmovieapp.data.entity.Movie
import com.example.testmovieapp.di.ui.BaseViewModel
import com.example.testmovieapp.repository.detail.DetailRepository
import com.example.testmovieapp.util.api_key
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : BaseViewModel() {
    private val _similarMovies = MutableLiveData<List<Movie>>()
    val similarMovie: LiveData<List<Movie>>
        get() = _similarMovies

    /**
     * to fetch the similar movie list
     */
    @SuppressLint("LogNotTimber")
    fun similarMovies(id: String) {
        compositeDisposable.add(
            detailRepository.getSimilarMovies(id, api_key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val movieResponse = it.results
                    _similarMovies.value = movieResponse
                }, {
                    Log.e("Error:::", it.localizedMessage!!)
                })
        )
    }
}