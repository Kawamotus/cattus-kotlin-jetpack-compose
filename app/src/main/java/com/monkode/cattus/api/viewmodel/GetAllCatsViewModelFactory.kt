package com.monkode.cattus.api.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monkode.cattus.api.repositories.CatsRepository

class GetAllCatsViewModelFactory(
  private val repository: CatsRepository
): ViewModelProvider.Factory {
  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if(modelClass.isAssignableFrom(GetAllCatsViewModel::class.java)) {
      return GetAllCatsViewModel(repository) as T
    }

    throw IllegalArgumentException("Unknown ViewModel Class")
  }
}