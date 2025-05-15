package com.monkode.cattus.ui.screens.cat.register

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.ui.components.CustomButton
import com.monkode.cattus.ui.components.CustomTextField
import com.monkode.cattus.ui.components.DateInputField
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.White000
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun RegisterStepOne(
  catData: CatData,
  onDataChange: (CatData) -> Unit,
  onProceedClick: () -> Unit
) {
  var showDatePicker by remember() { mutableStateOf(false) }
  var datePickerState = rememberDatePickerState()

  val sexos = listOf("Macho", "Femea") //arrumar isso
  var expanded by remember { mutableStateOf(false) }

  if (showDatePicker) {
    DatePickerDialog(
      onDismissRequest = { showDatePicker = false },
      confirmButton = {
        TextButton(
          onClick = {
            showDatePicker = false
            val selectedDate = datePickerState.selectedDateMillis?.let {
              SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(it))
            }
            if (selectedDate != null) {
              onDataChange(catData.copy(petBirth = selectedDate))
            }
          }
        ) {
          Text("OK")
        }
      }
    ) {
      DatePicker(state = datePickerState)
    }
  }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Black400)
      .padding(16.dp, 0.dp),
    verticalArrangement = Arrangement.Center
  ) {
    Text("Nome", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = catData.petName ?: "",
      onValueChange = { newValue ->
        onDataChange(catData.copy(petName = newValue))
      },
      placeholderText = "ex: Mingau",
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(20.dp))

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      Column(modifier = Modifier.weight(1f)) {
        Text("Data de nascimento", style = TextStyle(color = White000, fontSize = 16.sp))
        Spacer(modifier = Modifier.height(8.dp))

        DateInputField(
          value = catData.petBirth ?: "",
          onClick = { showDatePicker = true }
        )
      }

      Column(modifier = Modifier.weight(1f)) {
        Text("Sexo", style = TextStyle(color = White000, fontSize = 16.sp))
        Spacer(modifier = Modifier.height(8.dp))
        ExposedDropdownMenuBox(
          expanded = expanded,
          onExpandedChange = {
            expanded = !expanded
            Log.d("petGender", "click")
          }
        ) {
          CustomTextField(
            value = catData.petGender ?: "",
            onValueChange = { },
            placeholderText = "sexo",
            modifier = Modifier
            //.padding()
            ,
            trailingIcon = {
              ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            readOnly = true
          )
          ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
          ) {
            sexos.forEach {
              DropdownMenuItem(
                text = { Text(it) },
                onClick = {
                  onDataChange(catData.copy(petGender = it))
                  expanded = false
                }
              )
            }
          }
        }
      }

    }

    Spacer(modifier = Modifier.height(20.dp))

    Text("Observacoes", style = TextStyle(color = White000, fontSize = 16.sp))
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
      value = catData.petObs ?: "",
      onValueChange = { newValue ->
        onDataChange(catData.copy(petObs = newValue))
      },
      modifier = Modifier
        .height(140.dp)
        .fillMaxWidth(),
      singleLine = false
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