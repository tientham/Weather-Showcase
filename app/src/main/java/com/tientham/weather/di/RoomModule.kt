package com.tientham.weather.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.tientham.weather.data.WeatherRoomDatabase
import com.tientham.weather.worker.SeedDatabaseWorker
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.concurrent.thread

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
                    thread {
                        initDb(db)
                    }
                }
            })
            .build()
    }

    fun initDb(db: SupportSQLiteDatabase) {
        db.execSQL("INSERT INTO \"weather\" VALUES (1, \"London\", \"sunny\", \"26 C\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (2, \"Hanoi\", \"sunny\", \"30 C\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (3, \"Torino\", \"rain\", \"26 C\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (4, \"Paris\", \"cloudy\", \"32 C\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (5, \"Berlin\", \"sunny\", \"27 C\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (6, \"Moscow\", \"snow\", \"12 C\");")
    }
}