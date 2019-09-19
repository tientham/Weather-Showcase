package com.tientham.weather.data.repository

import android.content.Context
import com.tientham.weather.data.WeatherRoomDatabase
import com.tientham.weather.data.dao.UserDao
import com.tientham.weather.data.model.entities.User
import com.tientham.weather.ui.WeatherApplication
import javax.inject.Inject

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
class UserRepository {

    @Inject lateinit var database: WeatherRoomDatabase

    private val userDao: UserDao

    constructor(ctx: Context) {
        val app = ctx.applicationContext as WeatherApplication
        app.androidInjector().inject(this)
        userDao = database.userDao()
    }

    fun getUser(username: String): User {
        return userDao.getUserByUsername(username)
    }

    fun updateUser(user: User) {
        userDao.update(user)
    }
}