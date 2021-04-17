package com.example.mobillabor.ui.meterage

import com.example.mobillabor.ui.Presenter
import javax.inject.Inject

class MeteragePresenter @Inject constructor():  Presenter<MeterageScreen>() {

    fun CreateNewMeterage() {
        screen?.showSucces();
    }

    fun GetScales() {
        val scales = floatArrayOf(3001.1f, 3002.1f, 3000.4f, 3002.4f);
        screen?.updateScales(scales);
    }
}