package com.example.mobillabor.ui.list

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.mobillabor.data.DataSource
import com.example.mobillabor.model.Meterage
import com.example.mobillabor.network.MeteragesApi
import com.example.mobillabor.ui.Presenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ListPresenter @Inject constructor(
    private var meterageApi: MeteragesApi,
    private val dataSource: DataSource,
): Presenter<ListScreen?>() {

    fun queryMeterages(){
        GlobalScope.launch {
            var meterages = dataSource.getAllMeterages()
            Log.d("DB", meterages.size.toString());
            screen?.showList(meterages);
        }
        val addQueryCall = meterageApi.meterages;
        addQueryCall?.enqueue(object : Callback<Map<String, Meterage?>?> {
            override fun onFailure(call: Call<Map<String, Meterage?>?>, t: Throwable) {
                Log.d("ADD", "Error")
            }
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onResponse(call: Call<Map<String, Meterage?>?>, response: Response<Map<String, Meterage?>?>) {
                val list = listOf<Meterage>().toMutableList()
                response.body()?.forEach{ k, v ->
                    run {
                        if (v != null) {
                            v.id = k
                            list.add(v)
                        }
                    }
                }
                Log.d("ADD", list.size.toString())
                screen?.showList(list);
            }
        })
    }
}