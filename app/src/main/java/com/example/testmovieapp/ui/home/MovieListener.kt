package com.example.testmovieapp.ui.home

interface MovieListener {
    fun onFetchStarted()
    fun onFetchFinished()
    fun onFailure(message: String)
}