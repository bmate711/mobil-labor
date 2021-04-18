package com.example.mobillabor.ui.list

import android.util.Log
import com.example.mobillabor.model.Meterage
import com.example.mobillabor.network.MeteragesApi
import com.example.mobillabor.ui.Presenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ListPresenter @Inject constructor(private var meterageApi: MeteragesApi): Presenter<ListScreen?>() {

    override fun attachScreen(screen: ListScreen?) {
        super.attachScreen(screen)
    }


    override fun detachScreen() {
        super.detachScreen()
    }

    fun queryMeterages(){
        val addQueryCall = meterageApi.meterages;
        addQueryCall?.enqueue(object : Callback<Map<String, Meterage?>?> {
            override fun onFailure(call: Call<Map<String, Meterage?>?>, t: Throwable) {
                Log.d("ADD", "Error")
            }
            override fun onResponse(call: Call<Map<String, Meterage?>?>, response: Response<Map<String, Meterage?>?>) {
                response.body()?.forEach{ k, v ->
                    run {
                        Log.d("ADD", k)
                        Log.d("ADD", v?.date.toString())
                        Log.d("ADD", v?.product.toString())
                        Log.d("ADD", v?.place.toString())
                        Log.d("ADD", v?.license.toString())
                        Log.d("ADD", v?.values.toString())
                    }
                }

            }
        })
    }
}