package com.monkode.cattus.api.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.api.repositories.CatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GetAllCatsViewModel(
  private val repository: CatsRepository
): ViewModel() {
  sealed class UiState {
    object Loading: UiState()
    data class Success(val cats: List<CatData>): UiState()
    data class Error(val message: String): UiState()
    object Idle: UiState()
  }

  private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
  val uiState: StateFlow<UiState> = _uiState

  fun getCats() {
    if(_uiState.value is UiState.Loading) return

    _uiState.value = UiState.Loading

    viewModelScope.launch {
      val result = repository.getAllCats()
      _uiState.value = if(result.isSuccess) {
        val cats = result.getOrNull() ?: emptyList()
        UiState.Success(cats)
      } else {
        UiState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
      }
    }
  }
}