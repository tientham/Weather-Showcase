package com.tientham.weather.data.repository

import android.content.Context
import com.tientham.weather.data.model.entities.User

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
class UserRepository(context: Context): DbRepository(context) {

    private val userDao = database.userDao()

    fun getUser(username: String): User {
        return userDao.getUserByUsername(username)
    }

    fun updateUser(user: User) {
        userDao.update(user)
    }
}