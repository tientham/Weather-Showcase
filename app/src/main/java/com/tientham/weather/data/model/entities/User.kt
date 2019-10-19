package com.tientham.weather.data.model.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
@Entity(tableName = "user")
data class User(
    @field:ColumnInfo var username: String,
    @field:ColumnInfo var password: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo
    var displayName: String? = null

    @ColumnInfo
    var token: String? = null
}