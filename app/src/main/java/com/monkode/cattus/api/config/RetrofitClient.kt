package com.monkode.cattus.api.config

import android.content.Context
import com.monkode.cattus.api.interfaces.AuthService
import com.monkode.cattus.constants.baseUrl
import com.monkode.cattus.storage.SessionManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun getInstance(context: Context): Retrofit {
        val sessionManager = SessionManager(context)
        //val okHttpClient =
        //    OkHttpClient.Builder().addInterceptor(AuthInterceptor(sessionManager)).build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            //.client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

   /* val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    } */
}