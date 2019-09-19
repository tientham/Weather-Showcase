package com.tientham.weather.di

import com.tientham.weather.data.repository.UserRepository
import com.tientham.weather.data.repository.WeatherRepository
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-18.
 */
@Module
interface AppInjectModule {

    @ContributesAndroidInjector
    fun injectUserRepository() : UserRepository

    @ContributesAndroidInjector
    fun injectWeatherRepository() : WeatherRepository
}