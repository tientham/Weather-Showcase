package com.tientham.weather.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tientham.weather.data.dao.UserDao
import com.tientham.weather.data.dao.WeatherDao
import com.tientham.weather.data.model.entities.User
import com.tientham.weather.data.model.entities.Weather

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
@Database(
    version = 1,
    exportSchema = true,
    entities = [
        User::class,
        Weather::class
    ]
)
abstract class WeatherRoomDatabase : RoomDatabase() {

    public abstract fun userDao(): UserDao

    public abstract fun weatherDao(): WeatherDao
}