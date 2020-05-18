package com.example.testmovieapp.di.key

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Used as a part of multibinding
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)