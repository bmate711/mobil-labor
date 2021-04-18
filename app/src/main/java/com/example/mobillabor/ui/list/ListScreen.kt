package com.example.mobillabor.ui.list

import com.example.mobillabor.model.Meterage

interface ListScreen {
    fun showList(list: List<Meterage>);
}