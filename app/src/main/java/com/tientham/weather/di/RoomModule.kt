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
        db.execSQL("INSERT INTO \"weather\" VALUES (1, \"London\", \"sunny\", \"26 C\", \"https://images.unsplash.com/photo-1505761671935-60b3a7427bad?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (2, \"Hanoi\", \"sunny\", \"30 C\", \"https://images.unsplash.com/photo-1547158291-06774526756c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (3, \"Torino\", \"rain\", \"26 C\", \"https://images.unsplash.com/photo-1559227164-e7bcac17c7b7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (4, \"Paris\", \"cloudy\", \"32 C\", \"https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (5, \"Berlin\", \"sunny\", \"27 C\", \"https://images.unsplash.com/photo-1559564484-e48b3e040ff4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80\");")
        db.execSQL("INSERT INTO \"weather\" VALUES (6, \"Moscow\", \"snow\", \"12 C\", \"https://images.unsplash.com/photo-1547448415-e9f5b28e570d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80\");")
    }
}