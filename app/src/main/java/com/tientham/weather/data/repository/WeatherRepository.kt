package com.tientham.weather.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.tientham.weather.data.dao.WeatherDao
import com.tientham.weather.data.model.entities.Weather

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
class WeatherRepository(context: Context): DbRepository(context) {

    private val weatherDao: WeatherDao = database.weatherDao()

    fun getWeathers(): LiveData<List<Weather>> {
        return weatherDao.getWeathers()
    }
}