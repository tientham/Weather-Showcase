package com.tientham.weather.extension

import android.graphics.drawable.Drawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-10-17.
 */
fun Fragment.popBackStack() {
    NavHostFragment.findNavController(this).popBackStack()
}

fun Fragment.navigate(id: Int) {
    NavHostFragment.findNavController(this).navigate(id)
}

fun Fragment.navigate(directions: NavDirections) {
    NavHostFragment.findNavController(this).navigate(directions)
}

fun View.openKeyboard() {
    val inputMethodManager = ContextCompat.getSystemService(context, InputMethodManager::class.java)
    inputMethodManager?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.closeKeyboard() {
    val inputMethodManager = ContextCompat.getSystemService(context, InputMethodManager::class.java)
    inputMethodManager?.hideSoftInputFromWindow(this.windowToken, 0)
}

fun Fragment.getDrawable(id: Int): Drawable? {
    return ContextCompat.getDrawable(requireContext(), id)
}