package com.example.testnavigation.ui.details

import android.util.Log
import com.example.testnavigation.data.DataSource
import com.example.testnavigation.model.Meterage
import com.example.testnavigation.model.MeteragePostResponse
import com.example.testnavigation.network.MeteragesApi
import com.example.testnavigation.ui.Presenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private var meterageApi: MeteragesApi,
    private val dataSource: DataSource
): Presenter<DetailsScreen?>() {
    fun queryMeterageDetails(id: String) {
        GlobalScope.launch {
            var meterage = dataSource.getMeterage(id);
            if (meterage != null) {
                screen?.showMeterageDetails(meterage, false)
                screen?.showSaved(true)
            }
        }
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
                var meterage = Meterage()
                meterage.license = response.body()?.license;
                meterage.place = response.body()?.place;
                meterage.date = response.body()?.date;
                meterage.product = response.body()?.product;
                meterage.values = response.body()?.values;
                meterage.id = id;
                screen?.showMeterageDetails(meterage, true);
            }
        })
    }

    fun deleteMeterage(meterage: Meterage){
        val addQueryCall = meterageApi.deleteMeterage(meterage.id);
        addQueryCall?.enqueue(object : Callback<Void?> {
            override fun onFailure(call: Call<Void?>, t: Throwable) {
                Log.d("ADD", "Error")
            }
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                Log.d("ADD", "Delete was successful")
                removeMeterage(meterage)
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
                GlobalScope.launch {
                    meterage.id = id;
                    dataSource.updateMeterage(meterage)
                    Log.d("DB", "Updated");
                }
            }
        })
    }

    fun saveMeterage(meterage: Meterage) {
        GlobalScope.launch {
            dataSource.saveMeterage(meterage)
            Log.d("DB", "Save");
            screen?.showSaved(true);
        }
    }

    fun removeMeterage(meterage: Meterage) {
        GlobalScope.launch {
            dataSource.deleteMeterage(meterage)
            Log.d("DB", "Removed");
            screen?.showSaved(false);
        }
    }
}