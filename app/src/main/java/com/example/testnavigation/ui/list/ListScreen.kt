package com.example.testnavigation.ui.list

import com.example.testnavigation.model.Meterage

interface ListScreen {
    fun showList(list: List<Meterage>);
}