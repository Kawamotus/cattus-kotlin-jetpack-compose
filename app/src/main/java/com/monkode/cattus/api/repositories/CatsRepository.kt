package com.monkode.cattus.api.repositories

import com.monkode.cattus.api.interfaces.GetAllCatsInterface
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager

class CatsRepository(
  private val apiService: GetAllCatsInterface,
  private val userDataManager: UserDataManager,
  private val sessionManager: SessionManager
) {
  suspend fun getAllCats(): Result<List<CatData>> {
    val company = userDataManager.getCompany()!!
    val token = sessionManager.getToken()!!

    return try {
      val response = apiService.getAllCats(company, token)

      if(response.ok) {
        Result.success(response.result)
      } else {
        Result.failure(RuntimeException("Failed to get data from API"))
      }
    } catch(e: Exception) {
      Result.failure(e)
    }
  }
}