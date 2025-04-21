package com.monkode.cattus.api.config

import com.monkode.cattus.storage.SessionManager
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

//nao funciona
class AuthInterceptor(
    private val sessionManager: SessionManager
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        if(originalRequest.url().encodedPath().contains("/login")){
            return chain.proceed(originalRequest)
        }

        val token = runBlocking { sessionManager.getToken() }
        val newRequest = originalRequest.newBuilder().apply {
            if(!token.isNullOrEmpty()){
                addHeader("Authorization", token)
            }
        }.build()

        return chain.proceed(newRequest)
    }
}