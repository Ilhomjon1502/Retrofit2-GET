package com.ilhomjon.retrofit2.Retrofit

object Common {
    var BASE_URL = "https://www.simplifiedcoding.net/demos/"

    val retrofitService:RetrofitService
    get() = RetrofitClient.getRetrofit(BASE_URL).create(RetrofitService::class.java)
}