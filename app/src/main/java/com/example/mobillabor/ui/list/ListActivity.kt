package com.example.mobillabor.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillabor.R

class ListActivity : AppCompatActivity(), ListScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }

    override fun onStart() {
        super.onStart()
        ListPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        ListPresenter.detachScreen()
    }

    override fun onResume() {
        super.onResume()
        ListPresenter.queryMeterages(this)
    }

    override fun showList(list: List<String>) {
        TODO("Not yet implemented")
    }

}