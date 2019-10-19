package com.tientham.weather.data.model.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
@Entity(tableName = "weather")
data class Weather(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @field:ColumnInfo(name = "city") var city: String,
    @field:ColumnInfo(name = "status") var status: String,
    @field:ColumnInfo(name = "degree") var degree: String
)