package com.monkode.cattus.api.interfaces

import com.monkode.cattus.api.models.LoginRequest
import com.monkode.cattus.api.models.LoginRespose
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/employee/login")
    suspend fun login(@Body request: LoginRequest): LoginRespose
}