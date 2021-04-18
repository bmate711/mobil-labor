package com.example.mobillabor.ui.meterage

import android.util.Log
import com.example.mobillabor.data.DataSource
import com.example.mobillabor.model.Meterage
import com.example.mobillabor.model.MeteragePostResponse
import com.example.mobillabor.network.MeteragesApi
import com.example.mobillabor.ui.Presenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class MeteragePresenter @Inject constructor(
    private var meterageApi: MeteragesApi,
    private val dataSource: DataSource
    ):  Presenter<MeterageScreen>() {

    fun CreateNewMeterage(meterage: Meterage) {
        val addQueryCall = meterageApi.addMeterage(meterage);
        addQueryCall?.enqueue(object : Callback<MeteragePostResponse?> {
            override fun onFailure(call: Call<MeteragePostResponse?>, t: Throwable) {
                Log.d("ADD", "Error")
            }
            override fun onResponse(call: Call<MeteragePostResponse?>, response: Response<MeteragePostResponse?>) {
                Log.d("ADD", response.body()?.name.toString());
                meterage.id = response.body()?.name
                GlobalScope.launch {
                    dataSource.saveMeterage(meterage)
                    Log.d("DB", "Saved");
                }
                screen?.showSucces();
            }
        })
    }

    fun GetScales() {
        val scales = floatArrayOf(3001.1f, 3002.1f, 3000.4f, 3002.4f);
        screen?.updateScales(scales);
    }
}