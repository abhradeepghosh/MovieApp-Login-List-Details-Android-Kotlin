A simple android app that shows your favorite movies. In this solution, the following needs to be demonstrated 

 ## Project characteristics

This project brings to table set of best practices, tools, and solutions:

* Kotlin
* Model-View-View Model Architecture
* Android Jetpack
* Testing
* Dependency Injection
* Material design
 

 ## Tech-stack
 
This project takes advantage of many popular libraries and tools of the Android ecosystem. Most of the libraries are in the stable version.
 
 * Tech-stack
     * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform database queries operations.
     * [Rxjava2](https://github.com/ReactiveX/RxJava) - perform network calls.
     * [Glide](https://github.com/bumptech/glide) - Image loading and caching.
     * [Dagger 2](https://dagger.dev/) - dependency injection
     * [Room Database](https://developer.android.com/training/data-storage/room) - an abstraction layer over SQLite to allow fluent database access.
     * [Jetpack](https://developer.android.com/jetpack)
         * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
         * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes
         * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
     * [Stetho](http://facebook.github.io/stetho/) - application debugging tool - available on debug build only!!!
     * [Timber](http://jakewharton.github.io/timber/) - utility on top of Android's normal log class.
     * [Leak Canary](https://square.github.io/leakcanary/) - Memory detection library.
 * Architecture
     * MVVM - application level
     * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)
 * Tests
     * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/))
 
