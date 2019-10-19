package com.tientham.weather.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.tientham.weather.R
import com.tientham.weather.databinding.ItemWeatherSelectionBinding
import com.tientham.weather.utils.DataBoundListAdapter

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-10-19.
 */
class WeatherSelectionAdapter : DataBoundListAdapter<WeatherSelectionItemModel>(
    diffCallback = object : DiffUtil.ItemCallback<WeatherSelectionItemModel>() {
        override fun areContentsTheSame(
            oldItem: WeatherSelectionItemModel,
            newItem: WeatherSelectionItemModel
        ): Boolean {
            return oldItem.city == newItem.city && oldItem.status == newItem.status && oldItem.degree == newItem.degree
        }

        override fun areItemsTheSame(
            oldItem: WeatherSelectionItemModel,
            newItem: WeatherSelectionItemModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
) {
    override fun bind(binding: ViewDataBinding, item: WeatherSelectionItemModel) {
        when (binding) {
            is ItemWeatherSelectionBinding -> {
                binding.viewModel = item
            }
        }
    }

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_weather_selection,
            parent,
            false
        )
    }
}