package com.tientham.weather.di

import android.app.Application
import android.content.Context
import androidx.work.WorkManager
import com.tientham.weather.data.repository.PreferenceRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-18.
 */
@Module
class AppModule {

    @Provides
    fun applicationContext(app: Application) : Context = app.applicationContext

    @Singleton
    @Provides
    fun preferences(ctx: Context) = PreferenceRepository(ctx.applicationContext)

    @Provides
    fun provideWorkManager(ctx: Context) : WorkManager {
        return WorkManager.getInstance(ctx.applicationContext)
    }
}