package com.example.testnavigation.network

import com.example.testnavigation.model.Meterage
import com.example.testnavigation.model.MeteragePostResponse
import retrofit2.Call
import retrofit2.http.*

interface MeteragesApi {
    /**
     * Get all meterages
     * Returns all meterages
     * @return Call<List></List><InlineResponse200>>
    </InlineResponse200> */
    @get:GET("meterages.json")
    val meterages: Call<Map<String, Meterage?>?>?

    /**
     * Create a new meterage
     *
     * @param body Meterage object that needs to be added
     * @return Call<MeteragePostResponse>
    </MeteragePostResponse> */
    @POST("meterages.json")
    fun addMeterage(
        @Body body: Meterage?
    ): Call<MeteragePostResponse?>?

    /**
     * Find meterage by ID
     * Returns a single meterage
     * @param meterageId ID of meterage to return
     * @return Call<Meterage>
    </Meterage> */
    @GET("meterages/{meterageId}.json")
    fun getMeterageById(
        @Path("meterageId") meterageId: String?
    ): Call<Meterage?>?

    /**
     * Update an existing meterage
     *
     * @param meterageId ID of meterage to upsert
     * @param body Meterage object that needs to be added to the store
     * @return Call<Meterage>
    </Meterage> */
    @PUT("meterages/{meterageId}.json")
    fun updateMeterage(
        @Path("meterageId") meterageId: String?, @Body body: Meterage?
    ): Call<Meterage?>?

    /**
     * Deletes a pet
     *
     * @param meterageId ID of meterage to remove
     * @return Call<Void>
    </Void> */
    @DELETE("meterages/{meterageId}.json")
    fun deleteMeterage(
        @Path("meterageId") meterageId: String?
    ): Call<Void?>?
}