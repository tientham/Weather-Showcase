package com.tientham.weather.network.model

import com.google.gson.annotations.SerializedName

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-16.
 */
data class UserDTO (
    @SerializedName("username")
    val username: String,

    @SerializedName("userDisplayName")
    val userDisplayName: String?
) {
}