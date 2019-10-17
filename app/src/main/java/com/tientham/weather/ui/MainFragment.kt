package com.tientham.weather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.work.WorkManager
import com.tientham.weather.data.repository.PreferenceRepository
import com.tientham.weather.databinding.MainFragmentBinding
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class MainFragment : DaggerFragment() {

    @Inject internal lateinit var prefs : PreferenceRepository

    @Inject internal lateinit var workManager: WorkManager

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MainFragmentBinding.inflate(inflater).apply { lifecycleOwner = this@MainFragment }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            if (prefs.getToken().isNullOrEmpty()) {
                NavHostFragment.findNavController(this).navigate(MainFragmentDirections.actionMainFragmentToLoginFragment())
            } else {
                NavHostFragment.findNavController(this).navigate(MainFragmentDirections.actionMainFragmentToHomeFragment())
            }
        } catch (t: Throwable) {
            Timber.e(t)
        }
    }
}