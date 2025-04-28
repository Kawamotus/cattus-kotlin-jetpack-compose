package com.monkode.cattus.api.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monkode.cattus.api.config.RetrofitClient
import com.monkode.cattus.api.interfaces.GetAllCatsInterface
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.api.models.GetAllCats
import com.monkode.cattus.storage.UserDataManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GetAllCatsViewModel : ViewModel() {
    private val _catsResult = MutableStateFlow<List<CatData>?>(null)
    val catsResult: StateFlow<List<CatData>?> = _catsResult

    fun getCats(token: String, context: Context, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val userDataManager = UserDataManager(context)
                val company = userDataManager.getCompany()

                val service = RetrofitClient.getInstance(context).create(GetAllCatsInterface::class.java)
                val response = service.getAllCats(company!!, token)

                if(response.ok){
                    _catsResult.value = response.result
                } else {
                    onError("Failed to get data from api")
                }
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }
}