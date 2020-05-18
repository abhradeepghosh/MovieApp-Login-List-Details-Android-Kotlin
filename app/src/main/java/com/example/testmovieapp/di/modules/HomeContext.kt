package com.example.testmovieapp.di.modules

import android.content.Context
import com.example.testmovieapp.ui.home.HomeActivity
import com.example.testmovieapp.util.annotations.ActivityScope
import com.example.testmovieapp.util.annotations.qualifier.ActivityContext
import dagger.Module
import dagger.Provides


@Module
class MainActivityContextModule(private val mainActivity: HomeActivity) {
    var context: Context = mainActivity

    /**
     * provides the HomeActivity
     */
    @Provides
    @ActivityScope
    fun providesHomeActivity(): HomeActivity {
        return mainActivity
    }

    /**
     * Provides the context
     */
    @Provides
    @ActivityScope
    @ActivityContext
    fun provideContext(): Context {
        return context
    }

}