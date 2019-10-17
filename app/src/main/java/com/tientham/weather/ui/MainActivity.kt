package com.tientham.weather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.tientham.weather.R
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-17.
 */
class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            Navigation.findNavController(this, R.id.nav_host_fragment).addOnDestinationChangedListener {
                _, destination, _ -> Timber.v("Destination: ${destination.label}")
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()
    }
}