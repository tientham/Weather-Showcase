package com.tientham.weather.data.repository

import android.content.Context
import com.tientham.weather.data.WeatherRoomDatabase
import com.tientham.weather.ui.WeatherApplication
import javax.inject.Inject

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-10-19.
 */
open class DbRepository (context: Context) {

    @Inject
    internal lateinit var database: WeatherRoomDatabase

    init {
        val app = context.applicationContext as WeatherApplication
        app.androidInjector().inject(this)
    }
}