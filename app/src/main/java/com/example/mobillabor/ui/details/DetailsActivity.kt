package com.example.mobillabor.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillabor.R
import com.example.mobillabor.model.Meterage
import com.example.mobillabor.ui.meterage.MeteragePresenter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
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
        val meterage = Meterage()
        meterage.license = "AAA-000"
        meterage.place = "update"
        meterage.product = "product"
        meterage.date = Date();
        meterage.values =  floatArrayOf(3001.1f, 3002.1f, 3000.4f, 3002.4f)
        presenter.updateMeterage("-MYZ9H64gzqMMZVT50XC", meterage);
    }

    override fun showMeterageDetails(data: String) {

    }

    override fun showError(error: String) {

    }
}