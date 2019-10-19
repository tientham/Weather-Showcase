package com.tientham.weather.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.tientham.weather.R

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-10-19.
 */
class Utility {
    companion object {
        @JvmStatic
        fun getStatusImage(context: Context, status: String): Drawable? {
            when (status) {
                "sunny" -> { return ContextCompat.getDrawable(context, R.drawable.status_sunny) }
                "rain" -> { return ContextCompat.getDrawable(context, R.drawable.status_rain) }
                "snow" -> { return ContextCompat.getDrawable(context, R.drawable.status_snow) }
                "cloudy" -> { return ContextCompat.getDrawable(context, R.drawable.status_cloudy) }
                else -> return ContextCompat.getDrawable(context, R.drawable.status_sunny)
            }
        }
    }
}