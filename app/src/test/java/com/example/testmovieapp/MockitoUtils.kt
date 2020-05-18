package com.example.testmovieapp.ui

import org.mockito.Mockito

//a helper function to mock classes with types (generics)
inline fun <reified T> mock(): T = Mockito.mock(T::class.java)