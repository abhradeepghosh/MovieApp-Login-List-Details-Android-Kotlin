package com.example.testmovieapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testmovieapp.data.entity.Movie
import com.example.testmovieapp.di.ui.BaseViewModel
import com.example.testmovieapp.repository.home.HomeRepository
import com.example.testmovieapp.util.api_key
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    BaseViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies
    private var homeListener: MovieListener? = null

    /**
     * to fetch the list of movies
     */
    fun getMovie() {
        compositeDisposable.add(
            homeRepository.getPopularMovies(api_key)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { homeListener?.onFetchStarted() }
                .doOnTerminate { homeListener?.onFetchFinished() }
                .doOnComplete { homeListener?.onFetchFinished() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movie ->
                    homeRepository.getNowPlaying(api_key)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            val movieResponse = movie.results + it.results
                            _movies.value = movieResponse
                        }, {
                            homeListener?.onFailure(it.localizedMessage!!)
                        })
                }, {
                    homeListener?.onFailure(it.localizedMessage!!)
                })
        )
    }
}