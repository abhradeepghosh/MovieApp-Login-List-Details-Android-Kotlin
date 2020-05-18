package com.example.testmovieapp.util.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Defines the activity scope
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface ActivityScope {
}
