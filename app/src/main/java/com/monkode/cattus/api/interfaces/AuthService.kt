package com.monkode.cattus.api.interfaces

import com.monkode.cattus.api.models.LoginRequest
import com.monkode.cattus.api.models.LoginResponse
import com.monkode.cattus.api.models.UserData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("/employee/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}

interface UserDataService {
    @GET("/")
    suspend fun getUserData(@Header("Authorization") token: String): UserData
}