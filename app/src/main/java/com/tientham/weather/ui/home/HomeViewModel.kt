package com.tientham.weather.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tientham.weather.data.model.entities.Weather
import com.tientham.weather.data.repository.WeatherRepository

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class HomeViewModel: ViewModel() {

    var weatherList: ArrayList<Weather> = ArrayList()

    private var isLoading = MutableLiveData<Boolean>()

    fun getIsLoading() : MutableLiveData<Boolean> {
        return this.isLoading
    }

    fun getWeathers(context: Context): LiveData<List<WeatherSelectionItemModel>> {
        return Transformations.map(WeatherRepository(context).getWeathers()) {
            weatherList.addAll(it)
            createItems(it)
        }
    }

    private fun createItems(weathers: List<Weather>): List<WeatherSelectionItemModel> {
        val items: ArrayList<WeatherSelectionItemModel> = ArrayList()
        for (item in weathers) {
            items.add(WeatherSelectionItemModel(item.id, item.city, item.status, item.degree))
        }

        return items
    }
}