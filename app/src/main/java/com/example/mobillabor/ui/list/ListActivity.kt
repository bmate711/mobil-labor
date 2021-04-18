package com.example.mobillabor.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillabor.R
import com.example.mobillabor.model.Meterage
import com.example.mobillabor.ui.meterage.MeteragePresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListActivity : AppCompatActivity(), ListScreen {
    @Inject
    lateinit var presenter: ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }

    override fun onResume() {
        super.onResume()
        presenter.queryMeterages()
    }

    override fun showList(list: List<Meterage>) {
    }

}