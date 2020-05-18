package com.example.testmovieapp.di.ui

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()

    /**
     * to handle the clearance once view model operation is completed.
     */
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}