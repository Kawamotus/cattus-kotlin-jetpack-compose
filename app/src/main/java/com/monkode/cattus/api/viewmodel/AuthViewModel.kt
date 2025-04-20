package com.monkode.cattus.api.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monkode.cattus.api.config.RetrofitClient
import com.monkode.cattus.api.interfaces.AuthService
import com.monkode.cattus.api.models.LoginRequest
import com.monkode.cattus.api.models.LoginRespose
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _loginResult = MutableStateFlow<LoginRespose?>(null)
    val loginResult: StateFlow<LoginRespose?> = _loginResult

    fun login(employeeEmail: String, employeePassword: String, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val service = RetrofitClient.instance.create(AuthService::class.java)
                val response = service.login(LoginRequest(employeeEmail, employeePassword))
                _loginResult.value = response
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }
}