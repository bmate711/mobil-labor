package com.example.mobillabor.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        var meterage = Meterage()
        meterage.id = "-MY_-utpstpa0LKrqSf7"
        meterage.license = "ABC-987"
        meterage.place = "teszt";
        meterage.date = Date();
        meterage.product = "test p";
        meterage.values = floatArrayOf(3001.1f, 3002.1f, 3000.4f, 3002.4f);
        presenter.queryMeterageDetails("-MY_bcCq3mN7tnu6MHG5");
    }

    override fun showMeterageDetails(meterage: Meterage, fromAPI: Boolean) {
        Log.d("Details", meterage.place.toString());
        Log.d("Details", fromAPI.toString());

    }

    override fun showSaved(isSaved: Boolean) {

    }

    override fun showError(error: String) {

    }
}