package com.tientham.weather.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.squareup.picasso.Picasso
import com.tientham.weather.R
import com.tientham.weather.databinding.ItemWeatherSelectionBinding
import com.tientham.weather.utils.DataBoundListAdapter
import com.tientham.weather.utils.DataBoundViewHolder

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-10-19.
 */
class WeatherSelectionAdapter : DataBoundListAdapter<WeatherSelectionItemModel>(
    diffCallback = object : DiffUtil.ItemCallback<WeatherSelectionItemModel>() {
        override fun areContentsTheSame(
            oldItem: WeatherSelectionItemModel,
            newItem: WeatherSelectionItemModel
        ): Boolean {
            return oldItem.city == newItem.city && oldItem.status == newItem.status && oldItem.degree == newItem.degree && oldItem.photo == newItem.photo
        }

        override fun areItemsTheSame(
            oldItem: WeatherSelectionItemModel,
            newItem: WeatherSelectionItemModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
) {
    override fun onBindViewHolder(holder: DataBoundViewHolder, position: Int) {
        if (position < super.getItemCount()) {
            val item = getItem(position)
            Picasso.get().load(item.photo).fit().placeholder(R.mipmap.ic_launcher_round).into(holder.itemView.findViewById(R.id.imgCity) as ImageView)
            bind(holder.binding, item)
            holder.binding.executePendingBindings()
        }
    }

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