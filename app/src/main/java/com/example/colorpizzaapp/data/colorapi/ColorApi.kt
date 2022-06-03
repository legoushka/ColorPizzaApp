package com.example.colorpizzaapp.data.colorapi

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ColorApi {

    @GET("/v1/{hexColor}")
    @Headers("Content-Type: application/json")
    fun getColorList(@Path("hexColor") hexColor: String) : Single<ColorsRequestResponse>


}