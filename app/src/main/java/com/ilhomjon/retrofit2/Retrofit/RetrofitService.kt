package com.ilhomjon.retrofit2.Retrofit

import com.ilhomjon.retrofit2.Models.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("marvel")
    fun getMovie():Call<List<Movie>>
}