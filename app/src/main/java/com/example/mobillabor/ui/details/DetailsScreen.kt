package com.example.mobillabor.ui.details

import com.example.mobillabor.model.Meterage

interface DetailsScreen {
    fun showMeterageDetails(meterage: Meterage, fromAPI: Boolean);
    fun showSaved(isSaved: Boolean);
    fun showError(error: String);
}