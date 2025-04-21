package com.monkode.cattus.api.models

data class LoginRequest(
    val employeeEmail: String,
    val employeePassword: String
)

data class LoginResponse(
    val ok: Boolean,
    val message: String,
    val token: String
)

data class UserData(
    val id: String?,
    val name: String?,
    val picture: String?,
    val accessLevel: String?,
    val company: String?,
)