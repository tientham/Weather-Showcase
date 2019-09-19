package com.tientham.weather.data.model.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
@Keep
@Entity(tableName = "weather")
class Weather(
    @field:ColumnInfo var city: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo
    var status: String? = null

    @ColumnInfo
    var degree: String? = null
}