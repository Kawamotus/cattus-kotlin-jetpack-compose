package com.monkode.cattus.api.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monkode.cattus.api.config.RetrofitClient
import com.monkode.cattus.api.interfaces.AuthService
import com.monkode.cattus.api.interfaces.UserDataService
import com.monkode.cattus.api.models.LoginRequest
import com.monkode.cattus.api.models.LoginResponse
import com.monkode.cattus.api.models.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _loginResult = MutableStateFlow<LoginResponse?>(null)
    val loginResult: StateFlow<LoginResponse?> = _loginResult

    fun login(employeeEmail: String, employeePassword: String, context: Context, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val service = RetrofitClient.getInstance(context).create(AuthService::class.java)
                val response = service.login(LoginRequest(employeeEmail, employeePassword))
                _loginResult.value = response
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }
}

class UserDataViewModel: ViewModel() {
    private val _userDataResult = MutableStateFlow<UserData?>(null)
    val userDataResult: StateFlow<UserData?> = _userDataResult

    fun getUserData(token: String, context: Context, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val service = RetrofitClient.getInstance(context).create(UserDataService::class.java)
                val response = service.getUserData(token)
                _userDataResult.value = response
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }
}
