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
import com.monkode.cattus.api.models.PhysicalCharacteristics
import com.monkode.cattus.ui.components.CustomButton
import com.monkode.cattus.ui.components.CustomDropdownField
import com.monkode.cattus.ui.components.CustomTextField
import com.monkode.cattus.ui.components.IncrementDecrementField
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
  val color = listOf("preta", "branca", "cinza", "laranja", "marrom", "mesclada")
  val furLength = listOf("curto", "médio", "longo")

  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      .background(Black400)
      .padding(16.dp, 0.dp),
    verticalArrangement = Arrangement.Center
  ) {

    CustomDropdownField(
      label = "Castrado?",
      placeholder = "sim/nao",
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

    Spacer(modifier = Modifier.height(8.dp))

    IncrementDecrementField(
      label = "Peso (kg)",
      value = (catData.physicalCharacteristics ?: PhysicalCharacteristics()).weight ?: 1.0,
      onValueChange = { newValue ->
        onDataChange(
          catData.copy(
            physicalCharacteristics = (catData.physicalCharacteristics ?: PhysicalCharacteristics())
              .copy(weight = newValue)
          )
        )
      },
      minValue = .5,
      maxValue = 50.0,
      step = .1
    )

    Spacer(modifier = Modifier.height(8.dp))

    CustomDropdownField(
      label = "Cor",
      placeholder = "ex. preta",
      value = (catData.physicalCharacteristics ?: PhysicalCharacteristics()).furColor ?: "",
      options = color,
      onOptionSelected = { selected ->
        onDataChange(
          catData.copy(
            physicalCharacteristics = (catData.physicalCharacteristics ?: PhysicalCharacteristics())
              .copy(furColor = selected)
          )
        )
      }
    )

    Spacer(modifier = Modifier.height(8.dp))

    CustomDropdownField(
      label = "Pelagem",
      placeholder = "ex. curto",
      value = (catData.physicalCharacteristics ?: PhysicalCharacteristics()).furLength ?: "",
      options = furLength,
      onOptionSelected = { selected ->
        onDataChange(
          catData.copy(
            physicalCharacteristics = (catData.physicalCharacteristics ?: PhysicalCharacteristics())
              .copy(furLength = selected)
          )
        )
      }
    )

    Spacer(modifier = Modifier.height(8.dp))

    IncrementDecrementField(
      label = "Tamanho (cm)",
      value = (catData.physicalCharacteristics ?: PhysicalCharacteristics()).size ?: 15.0,
      onValueChange = { newValue ->
        onDataChange(
          catData.copy(
            physicalCharacteristics = (catData.physicalCharacteristics ?: PhysicalCharacteristics())
              .copy(size = newValue)
          )
        )
      },
      minValue = 5.0,
      maxValue = 50.0,
      step = 1.0
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text("Raça", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = (catData.petCharacteristics ?: PetCharacteristics()).petBreed ?: "",
      onValueChange = { newValue ->
        onDataChange(
          catData.copy(
            petCharacteristics = (catData.petCharacteristics ?: PetCharacteristics())
              .copy(petBreed = newValue)
          )
        )
      },
      placeholderText = "ex. vira lata",
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.weight(1f))

    CustomButton(
      onClick = {
        onProceedClick()
      },
      text = "Continuar",
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(8.dp))

  }
}