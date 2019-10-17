package com.tientham.weather.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class HomeViewModel: ViewModel() {

    private var isLoading = MutableLiveData<Boolean>()

    fun getIsLoading() : MutableLiveData<Boolean> {
        return this.isLoading
    }
}