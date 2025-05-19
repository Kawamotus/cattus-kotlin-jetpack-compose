package com.monkode.cattus.api.viewmodel.cameras

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monkode.cattus.api.models.CameraData
import com.monkode.cattus.api.repositories.CamerasRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GetAllCamerasViewModel(
  private val repository: CamerasRepository
): ViewModel() {
  sealed class UiState {
    object Loading: UiState()
    data class Success(val cameras: List<CameraData>): UiState()
    data class Error(val message: String): UiState()
    object Idle: UiState()
  }

  private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
  private val uiState: StateFlow<UiState> = _uiState

  fun getCameras() {
    if(uiState.value is UiState.Loading) return

    _uiState.value = UiState.Loading

    viewModelScope.launch {
      val result = repository.getAllCameras()
      _uiState.value = if (result.isSuccess) {
        val cameras = result.getOrNull() ?: emptyList()
        UiState.Success(cameras)
      } else {
        UiState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
      }
    }
  }
}