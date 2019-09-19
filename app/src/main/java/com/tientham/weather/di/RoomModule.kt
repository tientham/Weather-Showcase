package com.tientham.weather.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.tientham.weather.data.WeatherRoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoom(context: Context) : WeatherRoomDatabase {

        return Room.databaseBuilder(context.applicationContext,
            WeatherRoomDatabase::class.java, "WeatherShowCase.db")
            // prepopulate the database after onCreate was called
            .addCallback(object : RoomDatabase.Callback() {

                // Create and pre-populate the database. See this article for more details:
                // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    //val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                    //WorkManager.getInstance(context).enqueue(request)
                }
            })
            .build()
    }
}