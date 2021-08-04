package com.ilhomjon.retrofit2.Retrofit

import com.ilhomjon.retrofit2.Models.Movie
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

//    //oddiy holat
//    @GET("marvel")
//    fun getMovie():Call<List<Movie>>

    //RxJava bilan
    @GET("marvel")
    fun getMovie():Single<List<Movie>>
}