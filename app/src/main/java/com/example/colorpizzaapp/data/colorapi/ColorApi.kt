package com.example.colorpizzaapp.data.colorapi

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ColorApi {

    @GET("v1/{hexColor}")
    fun getColor(@Path("hexColor") hexColor: String) : Single<ColorsRequestResponse>


}