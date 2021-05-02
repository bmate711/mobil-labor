package com.example.testnavigation.ui.details

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.testnavigation.model.Meterage
import com.example.testnavigation.ui.meterage.MeteragePresenter
import com.example.testnavigation.R
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity(), DetailsScreen {
    @Inject
    lateinit var presenter: DetailsPresenter

    private var currentMeterageId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentMeterageId = bundle.getString("METERAGE_ID")
        }
        val buttonUpdate =  findViewById(R.id.buttonDetailsUpdate) as Button
        buttonUpdate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                val meterage1: TextView = findViewById(R.id.textViewDetailsMeterage1)
                val meterage2: TextView = findViewById(R.id.textViewDetailsMeterage2)
                val meterage3: TextView = findViewById(R.id.textViewDetailsMeterage3)
                val meterage4: TextView = findViewById(R.id.textViewDetailsMeterage4)

                val product: EditText = findViewById(R.id.editTextDetailsProduct)
                val place: EditText = findViewById(R.id.editTextDetailsPlace)
                val license: EditText = findViewById(R.id.editTextDetailsLicens)

                var meterage = Meterage()
                meterage.license = license.text.toString()
                meterage.place = place.text.toString()
                meterage.date = Date();
                meterage.product = product.text.toString()
                meterage.values = floatArrayOf(
                        meterage1.text.toString().toFloat(),
                        meterage2.text.toString().toFloat(),
                        meterage3.text.toString().toFloat(),
                        meterage4.text.toString().toFloat()
                );
                if (currentMeterageId != null) presenter.updateMeterage(currentMeterageId!!, meterage)
            }
        })

        val buttonDelete =  findViewById(R.id.buttonDetailsDelete) as Button
        buttonDelete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val meterage1: TextView = findViewById(R.id.textViewDetailsMeterage1)
                val meterage2: TextView = findViewById(R.id.textViewDetailsMeterage2)
                val meterage3: TextView = findViewById(R.id.textViewDetailsMeterage3)
                val meterage4: TextView = findViewById(R.id.textViewDetailsMeterage4)

                val product: EditText = findViewById(R.id.editTextDetailsProduct)
                val place: EditText = findViewById(R.id.editTextDetailsPlace)
                val license: EditText = findViewById(R.id.editTextDetailsLicens)

                var meterage = Meterage()
                meterage.license = license.text.toString()
                meterage.place = place.text.toString()
                meterage.date = Date();
                meterage.product = product.text.toString()
                meterage.values = floatArrayOf(
                        meterage1.text.toString().toFloat(),
                        meterage2.text.toString().toFloat(),
                        meterage3.text.toString().toFloat(),
                        meterage4.text.toString().toFloat()
                );
                meterage.id = currentMeterageId
                presenter.deleteMeterage(meterage)
                finish()
            }
        })

        val switch: Switch = this.findViewById(R.id.switchDetails)
        switch.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val switch: Switch = findViewById(R.id.switchDetails)
                val meterage1: TextView = findViewById(R.id.textViewDetailsMeterage1)
                val meterage2: TextView = findViewById(R.id.textViewDetailsMeterage2)
                val meterage3: TextView = findViewById(R.id.textViewDetailsMeterage3)
                val meterage4: TextView = findViewById(R.id.textViewDetailsMeterage4)

                val product: EditText = findViewById(R.id.editTextDetailsProduct)
                val place: EditText = findViewById(R.id.editTextDetailsPlace)
                val license: EditText = findViewById(R.id.editTextDetailsLicens)

                var meterage = Meterage()
                meterage.license = license.text.toString()
                meterage.place = place.text.toString()
                meterage.date = Date();
                meterage.product = product.text.toString()
                meterage.values = floatArrayOf(
                        meterage1.text.toString().toFloat(),
                        meterage2.text.toString().toFloat(),
                        meterage3.text.toString().toFloat(),
                        meterage4.text.toString().toFloat()
                );
                meterage.id = currentMeterageId
                if (switch.isChecked) {
                    presenter.saveMeterage(meterage)
                } else {
                    presenter.removeMeterage(meterage)
                }

            }
        })
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
        if(currentMeterageId != null) {
            presenter.queryMeterageDetails(currentMeterageId!!)
        }
    }

    override fun showMeterageDetails(meterage: Meterage, fromAPI: Boolean) {
        Log.d("Details", fromAPI.toString());
        this.runOnUiThread( Runnable() {
            val meterage1: TextView = this.findViewById(R.id.textViewDetailsMeterage1)
            val meterage2: TextView = this.findViewById(R.id.textViewDetailsMeterage2)
            val meterage3: TextView = this.findViewById(R.id.textViewDetailsMeterage3)
            val meterage4: TextView = this.findViewById(R.id.textViewDetailsMeterage4)

            meterage1.text = meterage.values?.get(0).toString()
            meterage2.text = meterage.values?.get(1).toString()
            meterage3.text = meterage.values?.get(2).toString()
            meterage4.text = meterage.values?.get(3).toString()

            val createAt: TextView = this.findViewById(R.id.textViewDetailsDate)
            createAt.text = meterage.date.toString()

            val place: EditText = this.findViewById(R.id.editTextDetailsPlace)
            place.setText(meterage.place)

            val license: EditText = this.findViewById(R.id.editTextDetailsLicens)
            license.setText(meterage.license)

            val product: EditText = this.findViewById(R.id.editTextDetailsProduct)
            product.setText(meterage.product)

        });
    }

    override fun showSaved(isSaved: Boolean) {
        this.runOnUiThread( Runnable() {
            val switch: Switch = this.findViewById(R.id.switchDetails)
            switch.isChecked = isSaved
        });

    }

    override fun showError(error: String) {
        Toast.makeText(this, "Error",
                Toast.LENGTH_LONG).show();
    }
}