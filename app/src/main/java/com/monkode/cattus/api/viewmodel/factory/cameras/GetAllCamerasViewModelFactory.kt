package com.monkode.cattus.api.viewmodel.factory.cameras

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monkode.cattus.api.repositories.CamerasRepository
import com.monkode.cattus.api.viewmodel.cameras.GetAllCamerasViewModel

class GetAllCamerasViewModelFactory(
  private val repository: CamerasRepository
): ViewModelProvider.Factory {
  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if(modelClass.isAssignableFrom(GetAllCamerasViewModel::class.java)) {
      return GetAllCamerasViewModel(repository) as T
    }

    throw IllegalArgumentException("Unknown ViewModel Class")
  }
}