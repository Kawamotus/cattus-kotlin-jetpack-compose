package com.monkode.cattus.api.repositories

import com.monkode.cattus.api.interfaces.CamerasApiInterface
import com.monkode.cattus.api.models.CameraData
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager

class CamerasRepository(
  private val apiService: CamerasApiInterface,
  private val userDataManager: UserDataManager,
  private val sessionManager: SessionManager
) {

  suspend fun getAllCameras(): Result<List<CameraData>> {
    val company = userDataManager.getCompany()!!
    val token = sessionManager.getToken()!!

    return try {
      val response = apiService.getAllCameras(company, token)

      if(response.ok) {
        Result.success(response.result)
      } else {
        Result.failure(RuntimeException("Failed to get data from API"))
      }
    } catch (e: Exception) {
      Result.failure(e)
    }
  }

}