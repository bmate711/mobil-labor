package com.example.mobillabor.ui.details

import android.util.Log
import com.example.mobillabor.model.Meterage
import com.example.mobillabor.model.MeteragePostResponse
import com.example.mobillabor.network.MeteragesApi
import com.example.mobillabor.ui.Presenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private var meterageApi: MeteragesApi): Presenter<DetailsScreen?>() {
    fun queryMeterageDetails(id: String) {
        val addQueryCall = meterageApi.getMeterageById(id);
        addQueryCall?.enqueue(object : Callback<Meterage?> {
            override fun onFailure(call: Call<Meterage?>, t: Throwable) {
                Log.d("ADD", "Error")
            }
            override fun onResponse(call: Call<Meterage?>, response: Response<Meterage?>) {
                Log.d("ADD", response.body()?.license.toString());
                Log.d("ADD", response.body()?.place.toString());
                Log.d("ADD", response.body()?.date.toString());
                Log.d("ADD", response.body()?.product.toString());
                Log.d("ADD", response.body()?.values.toString());
            }
        })
    }

    fun deleteMeterage(id: String){
        val addQueryCall = meterageApi.deleteMeterage(id);
        addQueryCall?.enqueue(object : Callback<Void?> {
            override fun onFailure(call: Call<Void?>, t: Throwable) {
                Log.d("ADD", "Error")
            }
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                Log.d("ADD", "Delete was successful");
            }
        })
    }

    fun updateMeterage(id: String, meterage: Meterage){
        val addQueryCall = meterageApi.updateMeterage(id, meterage);
        addQueryCall?.enqueue(object : Callback<Meterage?> {
            override fun onFailure(call: Call<Meterage?>, t: Throwable) {
                Log.d("ADD", "Error")
            }
            override fun onResponse(call: Call<Meterage?>, response: Response<Meterage?>) {
                Log.d("ADD", response.body()?.license.toString());
                Log.d("ADD", response.body()?.place.toString());
                Log.d("ADD", response.body()?.date.toString());
                Log.d("ADD", response.body()?.product.toString());
                Log.d("ADD", response.body()?.values.toString());
            }
        })
    }

    fun saveMeterage(id: String) {

    }

    fun unSaveMeterage(id: String) {

    }
}