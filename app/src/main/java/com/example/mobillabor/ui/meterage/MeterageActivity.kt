package com.example.mobillabor.ui.meterage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillabor.R
import com.example.mobillabor.model.Meterage
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
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
        val meterage = Meterage()
        meterage.license = "AAA-000"
        meterage.place = "teszt"
        meterage.product = "product"
        meterage.date = Date();
        meterage.values =  floatArrayOf(3001.1f, 3002.1f, 3000.4f, 3002.4f)
        presenter.CreateNewMeterage(meterage)
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