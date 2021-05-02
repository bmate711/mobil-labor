package com.example.testnavigation.ui.details

import com.example.testnavigation.model.Meterage

interface DetailsScreen {
    fun showMeterageDetails(meterage: Meterage, fromAPI: Boolean);
    fun showSaved(isSaved: Boolean);
    fun showError(error: String);
}