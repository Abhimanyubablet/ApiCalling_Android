package com.example.apicallingpractise

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiCalling {

  @GET("student")
    fun getUser(): Observable<List<DataModel>>
    companion object factory {
        fun create(): ApiCalling {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(" https://demo3553665.mockable.io/")
                .build()
            return retrofit.create(ApiCalling::class.java)

        }

    }
}