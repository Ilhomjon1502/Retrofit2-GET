package com.ilhomjon.retrofit2.Retrofit

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun getRetrofit(baseUrl:String, context: Context) : Retrofit{

//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//        //log da ko'rib turish uchun
//
//        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        //log da body qismi chiqib turadi
//        //link : https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor
//
//        val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(httpLoggingInterceptor)
//                .build()

//        val chuckInterceptor = ChuckInterceptor(context)
//
//        val okHttpClient = OkHttpClient.Builder()
//            .addInterceptor(chuckInterceptor)
//            .build()

        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .client(okHttpClient)
            .build()
        return build
    }
}