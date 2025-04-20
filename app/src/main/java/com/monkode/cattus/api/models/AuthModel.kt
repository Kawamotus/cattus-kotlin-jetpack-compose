package com.monkode.cattus.api.models

data class LoginRequest(
    val employeeEmail: String,
    val employeePassword: String
)

data class LoginRespose(
    val ok: Boolean,
    val message: String,
    val token: String
)
