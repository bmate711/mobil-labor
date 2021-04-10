package com.example.mobillabor.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillabor.R

class DetailsActivity : AppCompatActivity(), DetailsScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    override fun onStart() {
        super.onStart()
        DetailsPresenter.attachScreen(this)
    }

    override fun onStop() {
        DetailsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        DetailsPresenter.queryMeterageDetails("0");
    }

    override fun showMeterageDetails(data: String) {
        TODO("Not yet implemented")
    }

    override fun showError(error: String) {
        TODO("Not yet implemented")
    }
}