package com.monkode.cattus.api.viewmodel.cats

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monkode.cattus.api.models.BehavioralCharacteristics
import com.monkode.cattus.api.models.CreateNewCat
import com.monkode.cattus.api.models.PetCharacteristics
import com.monkode.cattus.api.models.PhysicalCharacteristics
import com.monkode.cattus.api.repositories.CatsRepository
import com.monkode.cattus.api.utils.uriToFile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class CreateNewCatViewModel(
  private val repository: CatsRepository
) : ViewModel() {
  sealed class UiState {
    object Loading : UiState()
    data class Success(val response: CreateNewCat) : UiState()
    data class Error(val message: String) : UiState()
    object Idle : UiState()
  }

  private val _catCreationState = MutableStateFlow<UiState>(UiState.Idle)
  val catCreationState: StateFlow<UiState> = _catCreationState

  fun createNewCat(
    imageUri: Uri?,
    petName: String,
    petBirth: String,
    petGender: String,
    petObs: String?,
    petComorbidities: String?,
    petCharacteristics: PetCharacteristics?,
    physicalCharacteristics: PhysicalCharacteristics?,
    behavioralCharacteristics: BehavioralCharacteristics?,
    context: Context
  ) {
    viewModelScope.launch {
      _catCreationState.value = UiState.Loading

      var petPicturePart: MultipartBody.Part? = null
      var tempImageFile: File? = null
      if (imageUri != null) {
        tempImageFile = uriToFile(imageUri, context)
        if (tempImageFile == null) {
          _catCreationState.value = UiState.Error("Não foi possível obter o arquivo de imagem")
          return@launch
        }

        val imageRequestBody = tempImageFile.asRequestBody("image/*".toMediaTypeOrNull())
        petPicturePart =
          MultipartBody.Part.createFormData("petPicture", tempImageFile.name, imageRequestBody)
      }

      val petNameBody =
        petName.toRequestBody("text/plain".toMediaTypeOrNull()) // Assume obrigatório

      val petBirthBody =
        petBirth.takeIf { it.isNotBlank() }?.toRequestBody("text/plain".toMediaTypeOrNull())
      val petGenderBody =
        petGender.takeIf { it.isNotBlank() }?.toRequestBody("text/plain".toMediaTypeOrNull())
      val petObsBody =
        petObs?.takeIf { it.isNotBlank() }?.toRequestBody("text/plain".toMediaTypeOrNull())
      val petComorbiditiesBody = petComorbidities?.takeIf { it.isNotBlank() }
        ?.toRequestBody("text/plain".toMediaTypeOrNull())

      val petCharacteristics_petCastrated_Body =
        petCharacteristics?.petCastrated?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())
      val petCharacteristics_petBreed_Body =
        petCharacteristics?.petBreed?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())
      val petCharacteristics_petSize_Body = petCharacteristics?.petSize?.takeIf { it.isNotBlank() }
        ?.toRequestBody("text/plain".toMediaTypeOrNull())

      val physicalCharacteristics_furColor_Body =
        physicalCharacteristics?.furColor?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())
      val physicalCharacteristics_furLength_Body =
        physicalCharacteristics?.furLength?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())
      val physicalCharacteristics_eyeColor_Body =
        physicalCharacteristics?.eyeColor?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())
      val physicalCharacteristics_size_Body =
        physicalCharacteristics?.size?.toString()?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())
      val physicalCharacteristics_weight_Body =
        physicalCharacteristics?.weight?.toString()?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())

      val behavioralCharacteristics_personality_Body =
        behavioralCharacteristics?.personality?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())
      val behavioralCharacteristics_activityLevel_Body =
        behavioralCharacteristics?.activityLevel?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())
      val behavioralCharacteristics_socialBehavior_Body =
        behavioralCharacteristics?.socialBehavior?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())
      val behavioralCharacteristics_meow_Body =
        behavioralCharacteristics?.meow?.takeIf { it.isNotBlank() }
          ?.toRequestBody("text/plain".toMediaTypeOrNull())


      val result = repository.createNewCat(
        petPicturePart!!,
        petNameBody,
        petBirthBody!!,
        petGenderBody!!,
        petObsBody,
        petComorbiditiesBody,
        petCharacteristics_petCastrated_Body,
        petCharacteristics_petBreed_Body,
        petCharacteristics_petSize_Body,
        physicalCharacteristics_furColor_Body,
        physicalCharacteristics_furLength_Body,
        physicalCharacteristics_eyeColor_Body,
        physicalCharacteristics_size_Body,
        physicalCharacteristics_weight_Body,
        behavioralCharacteristics_personality_Body,
        behavioralCharacteristics_activityLevel_Body,
        behavioralCharacteristics_socialBehavior_Body,
        behavioralCharacteristics_meow_Body
      )

      tempImageFile?.delete()

      _catCreationState.value = if (result.isSuccess) {
        UiState.Success(result.getOrThrow())
      } else {
        UiState.Error(
          result.exceptionOrNull()?.localizedMessage ?: "Erro desconhecido ao criar gato."
        )
      }
    }

  }
}