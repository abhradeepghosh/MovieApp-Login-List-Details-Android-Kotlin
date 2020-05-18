package com.example.testmovieapp

import android.app.Activity
import android.app.Application
import com.example.testmovieapp.di.component.ApplicationComponent
import com.example.testmovieapp.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import timber.log.Timber
import javax.inject.Inject

class App : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: App

        @JvmStatic
        fun getInstance() = instance
    }

    /**
     * Perform initialization of the Application
     */
    override fun onCreate() {
        super.onCreate()
        configureDagger()
        initTimber()
        instance = this
    }

    /**
     * Perform creation of the dagger application component
     */
    private fun configureDagger() {
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

    /**
     * to get the application component.
     */
    private fun getAppComponent(): ApplicationComponent {
        return applicationComponent
    }

    /**
     * Perform initialization of timber
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                @Nullable
                override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.lineNumber
                }
            })
        }
    }


}