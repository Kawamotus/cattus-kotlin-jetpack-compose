package com.monkode.cattus.api.models

data class GetAllCameras(
  val ok: Boolean,
  val result: List<CameraData>
)

data class CameraData (
  val _id: String,
  val cameraStatus: String? = null,
  val cameraLocation: String? = null,
  val cameraDescription: String? = null,
  val company: String? = null
)