package com.tientham.weather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tientham.weather.databinding.MainFragmentBinding
import dagger.android.support.DaggerFragment

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class MainFragment : DaggerFragment() {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MainFragmentBinding.inflate(inflater).apply { lifecycleOwner = this@MainFragment }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}