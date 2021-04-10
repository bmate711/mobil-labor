package hu.bme.aut.android.kotifydemo.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillabor.R
import com.example.mobillabor.ui.meterage.MeteragePresenter
import com.example.mobillabor.ui.meterage.MeterageScreen


class MeterageActivity : AppCompatActivity(), MeterageScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        MeteragePresenter.attachScreen(this)
    }

    override fun onResume() {
        super.onResume()
        MeteragePresenter.GetScales()
    }

    override fun onStop() {
        super.onStop()
        MeteragePresenter.detachScreen()
    }


    override fun showSucces() {
        TODO("Not yet implemented")
    }

    override fun updateScales(scales: FloatArray) {
        TODO("Not yet implemented")
    }
}