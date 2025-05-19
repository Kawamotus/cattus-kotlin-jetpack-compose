package com.monkode.cattus.api.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monkode.cattus.api.repositories.CatsRepository
import com.monkode.cattus.api.viewmodel.GetOneCatViewModel

class GetOneCatViewModelFactory(
  private val repository: CatsRepository
): ViewModelProvider.Factory {
  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if(modelClass.isAssignableFrom(GetOneCatViewModel::class.java)) {
      return GetOneCatViewModel(repository) as T
    }

    throw IllegalArgumentException("Unknown ViewModel Class")
  }
}