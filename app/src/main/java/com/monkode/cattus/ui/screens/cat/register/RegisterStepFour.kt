package com.monkode.cattus.ui.screens.cat.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.api.models.BehavioralCharacteristics
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.api.models.PetCharacteristics
import com.monkode.cattus.ui.components.CustomButton
import com.monkode.cattus.ui.components.CustomDropdownField
import com.monkode.cattus.ui.components.CustomTextField
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.White000

@Composable
fun RegisterStepFour(
  catData: CatData,
  onDataChange: (CatData) -> Unit,
  onProceedClick: () -> Unit
) {
  val personality = listOf("amigável", "reservado", "brincalhão", "independente", "arisco")
  val activityLevel = listOf("ativo", "moderado", "calmo")

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Black400)
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.Center
  ) {

    CustomDropdownField(
      label = "Personalidade",
      placeholder = "ex. amigável",
      value = (catData.behavioralCharacteristics ?: BehavioralCharacteristics()).personality ?: "",
      options = personality,
      onOptionSelected = { selected ->
        onDataChange(
          catData.copy(
            behavioralCharacteristics = (catData.behavioralCharacteristics
              ?: BehavioralCharacteristics())
              .copy(personality = selected)
          )
        )
      }
    )

    Spacer(modifier = Modifier.height(8.dp))

    CustomDropdownField(
      label = "Nível de atividade",
      placeholder = "ex. ativo",
      value = (catData.behavioralCharacteristics ?: BehavioralCharacteristics()).activityLevel
        ?: "",
      options = activityLevel,
      onOptionSelected = { selected ->
        onDataChange(
          catData.copy(
            behavioralCharacteristics = (catData.behavioralCharacteristics
              ?: BehavioralCharacteristics())
              .copy(activityLevel = selected)
          )
        )
      }
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text("Comportamento Social", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = (catData.behavioralCharacteristics ?: BehavioralCharacteristics()).socialBehavior
        ?: "",
      onValueChange = { newValue ->
        onDataChange(
          catData.copy(
            behavioralCharacteristics = (catData.behavioralCharacteristics
              ?: BehavioralCharacteristics())
              .copy(socialBehavior = newValue)
          )
        )
      },
      placeholderText = "ex. sociável",
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text("Nível de miado", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = (catData.behavioralCharacteristics ?: BehavioralCharacteristics()).meow ?: "",
      onValueChange = { newValue ->
        onDataChange(
          catData.copy(
            behavioralCharacteristics = (catData.behavioralCharacteristics
              ?: BehavioralCharacteristics())
              .copy(meow = newValue)
          )
        )
      },
      placeholderText = "ex. sociável",
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(28.dp))

    CustomButton(
      onClick = {
        onProceedClick()
      },
      text = "Continuar",
      modifier = Modifier.fillMaxWidth()
    )
  }
}
