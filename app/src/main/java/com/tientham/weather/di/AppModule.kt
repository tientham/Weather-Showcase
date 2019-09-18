package com.tientham.weather.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-18.
 */
@Module
class AppModule {

    @Provides
    fun applicationContext(app: Application) : Context = app.applicationContext
}