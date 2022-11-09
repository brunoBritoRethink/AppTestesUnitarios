package com.example.apptestunit.api

import com.example.apptestunit.models.MoviesModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/saga")
    fun getSaga(): Call<MutableList<MoviesModel>>

}