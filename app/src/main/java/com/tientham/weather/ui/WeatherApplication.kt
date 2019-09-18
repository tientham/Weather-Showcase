package com.tientham.weather.ui

import android.util.Log
import com.tientham.weather.BuildConfig
import com.tientham.weather.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class WeatherApplication: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(getTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }

    private fun getTree(): Timber.Tree {
        return if (BuildConfig.DEBUG) {
            Timber.DebugTree()
        } else {
            CrashReportingTree()
        }
    }

    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
                return
            }
        }
    }
}