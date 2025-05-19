package com.monkode.cattus.api.viewmodel.factory.cats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monkode.cattus.api.repositories.CatsRepository
import com.monkode.cattus.api.viewmodel.cats.GetAllCatsViewModel

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