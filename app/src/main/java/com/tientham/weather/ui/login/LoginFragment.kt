package com.tientham.weather.ui.login

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.tientham.weather.R
import com.tientham.weather.databinding.LoginFragmentBinding
import timber.log.Timber

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
        mBinding.btnLogin.background = ContextCompat.getDrawable(requireContext(), R.drawable.btn_disable)
        mBinding.btnLogin.setOnClickListener {
            if (isAllowToLogin()) {
                mBinding.tvErr.visibility = INVISIBLE
                mViewModel.getIsLoading().postValue(true)
            } else {
                mBinding.tvErr.visibility = VISIBLE
            }
        }

        val textWatcher = object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) {
                    mBinding.btnLogin.background = ContextCompat.getDrawable(requireContext(), R.drawable.btn_disable)
                } else {
                    mBinding.btnLogin.background = ContextCompat.getDrawable(requireContext(), R.drawable.btn_selector)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        }

        mBinding.nickName.addTextChangedListener(textWatcher)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.getIsLoading().removeObservers(this)

    }

    private fun isAllowToLogin(): Boolean {
        return !mBinding.nickName.text.isNullOrEmpty()
    }
}