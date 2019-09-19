package com.tientham.weather.ui.login

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.tientham.weather.databinding.LoginFragmentBinding

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class LoginFragment: Fragment() {

    private lateinit var mViewModel: LoginViewModel
    private lateinit var mBinding: LoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = LoginFragmentBinding.inflate(inflater)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val app = activity!!.application
        mViewModel = ViewModelProvider(this, LoginViewModel.Factory(app)).get(LoginViewModel::class.java)
        mBinding.viewmodel = mViewModel

        mViewModel.getIsLoading().observe(this, Observer {
            if (it) {
                Handler().postDelayed({
                    NavHostFragment.findNavController(this).navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                }, 2000)
            }
        })

        mBinding.btnLogin.setOnClickListener {
            mViewModel.getIsLoading().postValue(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.getIsLoading().removeObservers(this)
    }
}