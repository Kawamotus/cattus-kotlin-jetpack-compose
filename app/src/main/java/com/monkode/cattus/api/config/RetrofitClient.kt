package com.monkode.cattus.api.config

import android.content.Context
import com.monkode.cattus.constants.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun getInstance(context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            //.client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}