package com.example.testmovieapp.util.annotations

import javax.inject.Qualifier

/**
 * Qualifies Tmdb for network operations
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Tmdb