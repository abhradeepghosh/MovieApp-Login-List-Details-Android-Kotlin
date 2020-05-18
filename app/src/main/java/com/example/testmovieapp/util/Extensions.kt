package com.example.testmovieapp.util

import android.view.View
import android.widget.ProgressBar
import com.google.android.material.snackbar.Snackbar

/**
 * To show a progress bar
 */
fun ProgressBar.show() {
    visibility = View.VISIBLE
}

/**
 * To hide a progress bar
 */
fun ProgressBar.hide() {
    visibility = View.GONE
}

/**
 * To set a snackbar
 */
fun View.snackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .also { snackbar ->
            snackbar.setAction("Ok") {
                snackbar.dismiss()
            }
        }.show()
}