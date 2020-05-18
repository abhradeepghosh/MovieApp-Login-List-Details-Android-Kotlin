package com.example.testmovieapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testmovieapp.di.ViewModelFactory
import com.example.testmovieapp.di.key.ViewModelKey
import com.example.testmovieapp.ui.detail.DetailViewModel
import com.example.testmovieapp.ui.home.HomeViewModel
import com.example.testmovieapp.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    /**
     *
     * Multibinding: https://blog.kotlin-academy.com/understanding-dagger-2-multibindings-viewmodel-8418eb372848
     *
     */
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

}