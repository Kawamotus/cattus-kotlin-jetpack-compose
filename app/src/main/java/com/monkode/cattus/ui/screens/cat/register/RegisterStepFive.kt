package com.monkode.cattus.ui.screens.cat.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.ui.components.misc.CustomButton
import com.monkode.cattus.ui.components.textfields.CustomTextField
import com.monkode.cattus.ui.components.misc.EditableItemList
import com.monkode.cattus.ui.theme.White000

@Composable
fun RegisterStepFive(
  catData: CatData,
  onDataChange: (CatData) -> Unit,
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp)
      .verticalScroll(rememberScrollState())
  ) {
    Spacer(modifier = Modifier.height(8.dp))
    Text("Vacinas", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    EditableItemList(
      items = catData.petVaccines ?: listOf(),
      onItemsChange = { newList ->
        onDataChange(catData.copy(petVaccines = newList))
      },
      inputPlaceHolderText = "ex. raiva",
      modifier = Modifier.fillMaxWidth()
    )

    Text("Comorbidades", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = catData.petComorbidities ?: "",
      onValueChange = { newValue ->
        onDataChange(
          catData.copy(
            petComorbidities = newValue
          )
        )
      },
      placeholderText = "ex. problema urinario",
      modifier = Modifier.fillMaxWidth().height(140.dp),
      singleLine = false
    )

    Spacer(modifier = Modifier.weight(1f))

    CustomButton(
      onClick = {},
      text = "Enviar",
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(8.dp))
  }
}