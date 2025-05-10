package com.monkode.cattus.ui.screens.cat.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.api.models.PetCharacteristics
import com.monkode.cattus.ui.components.CustomButton
import com.monkode.cattus.ui.components.CustomDropdownField
import com.monkode.cattus.ui.components.CustomTextField
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.White000

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegisterStepThree(
  catData: CatData,
  onDataChange: (CatData) -> Unit,
  onProceedClick: () -> Unit
) {
  val yesOrNo = listOf("Sim", "Nao")

  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      .background(Black400)
      .padding(16.dp, 0.dp),
    verticalArrangement = Arrangement.Center
  ) {
    Spacer(modifier = Modifier.height(8.dp))
    CustomDropdownField(
      label = "Castrado?",
      value = (catData.petCharacteristics ?: PetCharacteristics()).petCastrated ?: "",
      options = yesOrNo,
      onOptionSelected = { selected ->
        onDataChange(
          catData.copy(
            petCharacteristics = (catData.petCharacteristics ?: PetCharacteristics())
              .copy(petCastrated = selected)
          )
        )
      }
    )

    Text("Raça", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = catData.petName ?: "",
      onValueChange = { newValue ->
        onDataChange(catData.copy(petName = newValue))
      },
      placeholderText = "ex: Mingau",
      modifier = Modifier.fillMaxWidth()
    )

    Text("Cor", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = catData.petName ?: "",
      onValueChange = { newValue ->
        onDataChange(catData.copy(petName = newValue))
      },
      placeholderText = "ex: Mingau",
      modifier = Modifier.fillMaxWidth()
    )

    Text("Pelagem", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = catData.petName ?: "",
      onValueChange = { newValue ->
        onDataChange(catData.copy(petName = newValue))
      },
      placeholderText = "ex: Mingau",
      modifier = Modifier.fillMaxWidth()
    )

    Text("Tamanho (tirar o textfield)", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = catData.petName ?: "",
      onValueChange = { newValue ->
        onDataChange(catData.copy(petName = newValue))
      },
      placeholderText = "ex: Mingau",
      modifier = Modifier.fillMaxWidth()
    )

    Text("Peso (tirar o textfield)", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = catData.petName ?: "",
      onValueChange = { newValue ->
        onDataChange(catData.copy(petName = newValue))
      },
      placeholderText = "ex: Mingau",
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    CustomButton(
      onClick = {
        onProceedClick()
      },
      text = "Continuar",
      modifier = Modifier.fillMaxWidth()
    )

  }
}