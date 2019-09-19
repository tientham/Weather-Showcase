package com.tientham.weather.data.repository

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.annotation.NonNull
import com.tientham.weather.data.WeatherRoomDatabase
import javax.inject.Inject

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
class PreferenceRepository(ctx: Context) {

    companion object {
        private const val PREF_KEY_USER_NAME = "PREF_KEY_USER_NAME"
        private const val PREF_KEY_TOKEN = "PREF_KEY_TOKEN"
    }

    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx.applicationContext)
    @Inject lateinit var database: WeatherRoomDatabase

    public fun setUsername(@NonNull userName: String) {
        prefs.edit().putString(PREF_KEY_USER_NAME, userName).apply()
    }

    public fun getUsername(): String {
        return prefs.getString(PREF_KEY_USER_NAME, "")!!
    }

    public fun setToken(@NonNull token: String) {
        prefs.edit().putString(PREF_KEY_TOKEN, token).apply()
    }

    public fun getToken(): String {
        return prefs.getString(PREF_KEY_TOKEN, "")!!
    }

    public fun clearAll() { prefs.edit().clear().apply() }
}