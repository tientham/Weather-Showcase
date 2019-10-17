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
import dagger.android.support.DaggerFragment

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class HomeFragment: DaggerFragment() {

    private val mViewModel: HomeViewModel by viewModels { SavedStateViewModelFactory(requireActivity().application, this) }
    private lateinit var mBinding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = HomeFragmentBinding.inflate(inflater).apply { lifecycleOwner = this@HomeFragment }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val app = activity!!.application
        mBinding.viewmodel = mViewModel

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.getIsLoading().removeObservers(this)
    }
}