package com.tientham.weather.data.dao

import androidx.room.*
import com.tientham.weather.data.model.entities.User

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)

    @Update
    fun update(user: User): Void

    @Query("SELECT * FROM user where username = :username")
    fun getUserByUsername(username: String): User

    @Query("SELECT * FROM user WHERE username = :username")
    fun getUsers(username: String): List<User>
}