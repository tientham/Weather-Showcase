package com.tientham.weather.ui.login

import android.app.Application
import androidx.lifecycle.*

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class LoginViewModel: AndroidViewModel {

    private var isLoading = MutableLiveData<Boolean>()


    constructor(application: Application): super(application) {
        this.isLoading.postValue(false)
    }

    fun getIsLoading() : MutableLiveData<Boolean> {
        return this.isLoading
    }

    class Factory(private var application: Application): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                return LoginViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}