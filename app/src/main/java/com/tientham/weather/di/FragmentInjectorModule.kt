package com.tientham.weather.di

import com.tientham.weather.ui.MainFragment
import com.tientham.weather.ui.home.HomeFragment
import com.tientham.weather.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-19.
 */
@Module
interface FragmentInjectorModule {

    @ContributesAndroidInjector
    fun injectLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    fun injectMainFragment(): MainFragment

    @ContributesAndroidInjector
    fun injectHomeFragment(): HomeFragment
}