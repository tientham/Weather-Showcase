package com.tientham.weather.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tientham.weather.data.model.entities.Weather

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weather: Weather): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(weathers: List<Weather>)

    @Update
    fun update(weather: Weather): Void

    @Query("SELECT * FROM weather where city = :city")
    fun getWeatherByCity(city: String): Weather

    @Query("SELECT * FROM weather")
    fun getWeathers(): LiveData<List<Weather>>
}