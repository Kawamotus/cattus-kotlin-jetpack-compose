package com.monkode.cattus.api.repositories

import com.monkode.cattus.api.interfaces.CatsApiService
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.api.models.CreateNewCat
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager
import okhttp3.MultipartBody
import okhttp3.RequestBody

class CatsRepository(
  private val apiService: CatsApiService,
  private val userDataManager: UserDataManager,
  private val sessionManager: SessionManager
) {
  suspend fun getAllCats(): Result<List<CatData>> {
    val company = userDataManager.getCompany()!!
    val token = sessionManager.getToken()!!

    return try {
      val response = apiService.getAllCats(company, token)

      if (response.ok) {
        Result.success(response.result)
      } else {
        Result.failure(RuntimeException("Failed to get data from API"))
      }
    } catch (e: Exception) {
      Result.failure(e)
    }
  }

  suspend fun getOneCat(animalId: String): Result<CatData> {
    val token = sessionManager.getToken()!!

    return try {
      val response = apiService.getOneCat(animalId, token)

      if (response.ok) {
        Result.success(response.result)
      } else {
        Result.failure(RuntimeException("Failed to get data from API"))
      }
    } catch (e: Exception) {
      Result.failure(e)
    }
  }

  suspend fun createNewCat(
    petPicture: MultipartBody.Part,
    petName: RequestBody,
    petBirth: RequestBody,
    petGender: RequestBody,
    petObs: RequestBody?,
    petComorbidities: RequestBody?,
    petCharacteristics_petCastrated: RequestBody?,
    petCharacteristics_petBreed: RequestBody?,
    petCharacteristics_petSize: RequestBody?,
    physicalCharacteristics_furColor: RequestBody?,
    physicalCharacteristics_furLength: RequestBody?,
    physicalCharacteristics_eyeColor: RequestBody?,
    physicalCharacteristics_size: RequestBody?,
    physicalCharacteristics_weight: RequestBody?,
    behavioralCharacteristics_personality: RequestBody?,
    behavioralCharacteristics_activityLevel: RequestBody?,
    behavioralCharacteristics_socialBehavior: RequestBody?,
    behavioralCharacteristics_meow: RequestBody?
  ): Result<CreateNewCat> {
    val token = sessionManager.getToken()!!
    val company = userDataManager.getCompany()!!

    return try {
      val response = apiService.createNewCat(
        petPicture,
        petName,
        petBirth,
        petGender,
        petObs,
        petComorbidities,
        company,
        petCharacteristics_petCastrated,
        petCharacteristics_petBreed,
        petCharacteristics_petSize,
        physicalCharacteristics_furColor,
        physicalCharacteristics_furLength,
        physicalCharacteristics_eyeColor,
        physicalCharacteristics_size,
        physicalCharacteristics_weight,
        behavioralCharacteristics_personality,
        behavioralCharacteristics_activityLevel,
        behavioralCharacteristics_socialBehavior,
        behavioralCharacteristics_meow,
        token
      )

      if (response.ok) {
        Result.success(response)
      } else {
        Result.failure(RuntimeException("Failed to create new cat"))
      }
    } catch (e: Exception) {
      Result.failure(e)
    }
  }
}