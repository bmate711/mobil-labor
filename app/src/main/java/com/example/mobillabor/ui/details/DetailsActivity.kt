package com.example.mobillabor.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillabor.R
import com.example.mobillabor.ui.meterage.MeteragePresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity(), DetailsScreen {
    @Inject
    lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        presenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        presenter.queryMeterageDetails("0");
    }

    override fun showMeterageDetails(data: String) {
        TODO("Not yet implemented")
    }

    override fun showError(error: String) {
        TODO("Not yet implemented")
    }
}