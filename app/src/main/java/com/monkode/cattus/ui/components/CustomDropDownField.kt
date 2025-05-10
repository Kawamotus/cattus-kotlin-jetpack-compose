package com.monkode.cattus.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ExposedDropdownMenuBox
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ExposedDropdownMenuDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.ui.theme.White000


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomDropdownField(
  label: String,
  value: String,
  options: List<String>,
  onOptionSelected: (String) -> Unit
) {
  var expanded by remember { mutableStateOf(false) }

  Text(label, style = TextStyle(color = White000, fontSize = 16.sp))
  Spacer(modifier = Modifier.height(8.dp))
  ExposedDropdownMenuBox(
    expanded = expanded,
    onExpandedChange = { expanded = !expanded }
  ) {
    CustomTextField(
      value = value,
      onValueChange = {}, // readOnly = true
      placeholderText = "sim/nao",
      readOnly = true,
      trailingIcon = {
        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
      },
      modifier = Modifier.fillMaxWidth()
    )

    ExposedDropdownMenu(
      expanded = expanded,
      onDismissRequest = { expanded = false }
    ) {
      options.forEach {
        DropdownMenuItem(
          text = { Text(it) },
          onClick = {
            onOptionSelected(it)
            expanded = false
          }
        )
      }
    }
  }
}