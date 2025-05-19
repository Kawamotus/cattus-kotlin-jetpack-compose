package com.monkode.cattus.api.viewmodel.cats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.api.repositories.CatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class GetOneCatViewModel(
  private val repository: CatsRepository
): ViewModel() {
  sealed class CatDetailsUiState {
    object Idle : CatDetailsUiState()
    object Loading : CatDetailsUiState()
    data class Success(val cat: CatData) : CatDetailsUiState()
    data class Error(val message: String) : CatDetailsUiState()
  }

  private val _uiState = MutableStateFlow<CatDetailsUiState>(CatDetailsUiState.Idle)
  val uiState: StateFlow<CatDetailsUiState> = _uiState

  fun loadCatDetails(animalId: String) {
    if(uiState.value is CatDetailsUiState.Loading) return

    _uiState.value = CatDetailsUiState.Loading

    viewModelScope.launch {
      val result = repository.getOneCat(animalId)

      _uiState.value = if(result.isSuccess) {
        val catDetails = result.getOrNull()

        if(catDetails != null) {
          CatDetailsUiState.Success(catDetails)
        } else {
          CatDetailsUiState.Error("Cat details not found")
        }
      } else {
        CatDetailsUiState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
      }
    }
  }

}