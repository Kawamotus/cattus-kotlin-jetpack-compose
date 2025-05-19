package com.monkode.cattus.api.viewmodel.cats

import androidx.lifecycle.ViewModel
import com.monkode.cattus.api.models.CreateNewCat
import com.monkode.cattus.api.repositories.CatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CreateNewCatViewModel(
  private val repository: CatsRepository
): ViewModel() {
  sealed class UiState {
    object Loading: UiState()
    data class Success(val response: CreateNewCat): UiState()
    data class Error(val message: String): UiState()
    object Idle: UiState()
  }

  private val _catCreationState = MutableStateFlow<UiState>(UiState.Idle)
  val catCreationState: StateFlow<UiState> = _catCreationState

  fun createNewCat()
}