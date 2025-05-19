package com.monkode.cattus.api.interfaces

import com.monkode.cattus.api.models.GetAllCats
import com.monkode.cattus.api.models.GetOneCat
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CatsApiService {
    @GET("/animal/select-all/{company}?limit=1000")
    suspend fun getAllCats(@Path("company") company: String, @Header("Authorization") token: String): GetAllCats

    @GET("animal/select-one/{animalId}")
    suspend fun getOneCat(@Path("animalId") animalId: String, @Header("Authorization") token: String): GetOneCat
}
