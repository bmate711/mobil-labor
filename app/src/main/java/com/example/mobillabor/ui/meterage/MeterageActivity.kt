package com.example.mobillabor.ui.meterage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillabor.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MeterageActivity : AppCompatActivity(), MeterageScreen {
    @Inject
    lateinit var presenter:  MeteragePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meterage)

    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.GetScales()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }


    override fun showSucces() {

    }

    override fun updateScales(scales: FloatArray) {

    }
}