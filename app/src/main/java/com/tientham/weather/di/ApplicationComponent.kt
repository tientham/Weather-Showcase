package com.tientham.weather.di

import android.app.Application
import com.tientham.weather.ui.WeatherApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-18.
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,

        AppInjectModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<WeatherApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}