package com.example.mobillabor.ui.list

import android.content.Context
import com.example.mobillabor.ui.Presenter
import javax.inject.Inject

class ListPresenter @Inject constructor(): Presenter<ListScreen?>() {

    override fun attachScreen(screen: ListScreen?) {
        super.attachScreen(screen)
    }


    override fun detachScreen() {
        super.detachScreen()
    }

    fun queryMeterages(contex: Context){

    }
}