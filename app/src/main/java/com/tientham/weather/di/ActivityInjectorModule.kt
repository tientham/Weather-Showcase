package com.tientham.weather.di

import com.tientham.weather.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-10-17.
 */
@Module
interface ActivityInjectorModule {

    @ContributesAndroidInjector
    fun injectMainActivity(): MainActivity
}