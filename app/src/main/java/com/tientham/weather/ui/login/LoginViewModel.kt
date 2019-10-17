package com.tientham.weather.ui.login

import androidx.lifecycle.*

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class LoginViewModel: ViewModel() {

    private var isLoading = MutableLiveData<Boolean>()

    fun getIsLoading() : MutableLiveData<Boolean> {
        return this.isLoading
    }
}