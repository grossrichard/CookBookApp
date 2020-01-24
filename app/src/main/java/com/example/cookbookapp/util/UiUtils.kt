package com.example.cookbookapp.util

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.example.cookbookapp.Application

/**
 * Created by Richard Gross on 2020-01-24
 */
object UiUtils {

    fun getColor(@ColorRes colorRes: Int): Int {
        return ContextCompat.getColor(Application.instance, colorRes)
    }

    fun getDrawable(@DrawableRes drawableRes: Int): Drawable? {
        return ContextCompat.getDrawable(Application.instance, drawableRes)
    }

}