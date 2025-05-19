package com.monkode.cattus.api.interfaces

import com.monkode.cattus.api.models.CreateNewCat
import com.monkode.cattus.api.models.GetAllCats
import com.monkode.cattus.api.models.GetOneCat
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface CatsApiService {
  @GET("animal/select-all/{company}?limit=1000")
  suspend fun getAllCats(
    @Path("company") company: String,
    @Header("Authorization") token: String
  ): GetAllCats

  @GET("animal/select-one/{animalId}")
  suspend fun getOneCat(
    @Path("animalId") animalId: String,
    @Header("Authorization") token: String
  ): GetOneCat

  @Multipart()
  @POST("animal/create")
  suspend fun createNewCat(
    @Part petPicture: MultipartBody.Part,
    @Part("petName") petName: RequestBody,
    @Part("petBirth") petBirth: RequestBody,
    @Part("petGender") petGender: RequestBody,
    @Part("petObs") petObs: RequestBody?,
    @Part("petComorbidities") petComorbidities: RequestBody?,
    @Part("company") company: String,
    @Part("petCharacteristics.petCastrated") petCharacteristics_petCastrated: RequestBody?,
    @Part("petCharacteristics.petBreed") petCharacteristics_petBreed: RequestBody?,
    @Part("petCharacteristics.petSize") petCharacteristics_petSize: RequestBody?,
    @Part("physicalCharacteristics.furColor") physicalCharacteristics_furColor: RequestBody?,
    @Part("physicalCharacteristics.furLength") physicalCharacteristics_furLength: RequestBody?,
    @Part("physicalCharacteristics.eyeColor") physicalCharacteristics_eyeColor: RequestBody?,
    @Part("physicalCharacteristics.size") physicalCharacteristics_size: RequestBody?,
    @Part("physicalCharacteristics.weight") physicalCharacteristics_weight: RequestBody?,
    @Part("behavioralCharacteristics.personality") behavioralCharacteristics_personality: RequestBody?,
    @Part("behavioralCharacteristics.activityLevel") behavioralCharacteristics_activityLevel: RequestBody?,
    @Part("behavioralCharacteristics.socialBehavior") behavioralCharacteristics_socialBehavior: RequestBody?,
    @Part("behavioralCharacteristics.meow") behavioralCharacteristics_meow: RequestBody?,

    @Header("Authorization") token: String
  ): CreateNewCat
}
