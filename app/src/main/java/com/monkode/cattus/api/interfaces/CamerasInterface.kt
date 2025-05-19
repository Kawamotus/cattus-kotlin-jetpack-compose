package com.monkode.cattus.api.interfaces

import com.monkode.cattus.api.models.GetAllCameras
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CamerasApiInterface {
  @GET("camera/select-all/{company}")
  suspend fun getAllCameras(
    @Path("company") company: String,
    @Header("Authorization") token: String
  ): GetAllCameras
}