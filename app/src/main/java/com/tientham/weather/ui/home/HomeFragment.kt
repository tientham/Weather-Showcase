package com.tientham.weather.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.tientham.weather.databinding.HomeFragmentBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tientham.weather.utils.ItemClickSupport
import dagger.android.support.DaggerFragment

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class HomeFragment: DaggerFragment() {

    private val mViewModel: HomeViewModel by viewModels { SavedStateViewModelFactory(requireActivity().application, this) }
    private lateinit var mBinding: HomeFragmentBinding
    private lateinit var mAdapter: WeatherSelectionAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = HomeFragmentBinding.inflate(inflater).apply { lifecycleOwner = this@HomeFragment }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.viewmodel = mViewModel

        mAdapter = WeatherSelectionAdapter()
        mBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }

        mViewModel.getWeathers(requireContext()).observe(viewLifecycleOwner, Observer {
            mAdapter.submitList(it)
            mAdapter.notifyDataSetChanged()
        })

        mViewModel.getIsLoading().observe(this, Observer {
            if (it) {
                Handler().postDelayed({
                    NavHostFragment.findNavController(this).navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
                }, 2000)
            }
        })

        mBinding.btnLogout.setOnClickListener {
            mViewModel.getIsLoading().postValue(true)
        }

        ItemClickSupport.addTo(mBinding.recyclerView)!!.setOnItemClickListener(weathersItemClickSupport)
    }

    private val weathersItemClickSupport = object : ItemClickSupport.OnItemClickListener {
        override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
            Snackbar.make(v, "Item clicked!", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.getIsLoading().removeObservers(this)
    }
}