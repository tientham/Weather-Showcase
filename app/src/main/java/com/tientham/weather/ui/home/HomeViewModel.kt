package com.tientham.weather.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class HomeViewModel: AndroidViewModel {

    private var isLoading = MutableLiveData<Boolean>()

    constructor(application: Application): super(application) {
        this.isLoading.postValue(false)
    }

    fun getIsLoading() : MutableLiveData<Boolean> {
        return this.isLoading
    }

    class Factory(private var application: Application): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}