package com.monkode.cattus.ui.components

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monkode.cattus.ui.theme.Green100
import com.monkode.cattus.ui.theme.Green300
import com.monkode.cattus.ui.theme.Purple400
import com.monkode.cattus.ui.theme.White000

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class,
  ExperimentalMaterialApi::class
)
@Composable
fun EditableItemList(
  items: List<String>,
  onItemsChange: (List<String>) -> Unit,
  modifier: Modifier = Modifier,
  inputLabel: String? = null,
  inputPlaceHolderText: String? = null
) {
  var inputText by remember { mutableStateOf("") }

  Column(
    modifier = Modifier.fillMaxWidth()
  ) {

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      CustomTextField(
        value = inputText,
        onValueChange = { inputText = it },
        //label = inputLabel?.let { { Text(it) } }
        placeholderText = inputPlaceHolderText,
        label = inputLabel,
        modifier = Modifier.weight(1f),
        singleLine = true
      )

      Button(
        onClick = {
          val trimmedText = inputText.trim()
          if (trimmedText.isNotBlank()) {
            val newList = items + trimmedText
            onItemsChange(newList.distinct())
            inputText = ""
          }
        },
        modifier = Modifier.height(56.dp),
        enabled = inputText.isNotBlank(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
          containerColor = Green300,
          contentColor = White000,
          disabledContainerColor = Green100
        )

      ) {
        Text("Adicionar")
      }

    }

    Spacer(modifier = Modifier.height(8.dp))

    FlowRow(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items.forEach { item ->
        InputChip(
          selected = true,
          onClick = {},
          label = { Text(item) },
          trailingIcon = {
            IconButton(
              onClick = {
                val newList = items.filter { it != item }
                onItemsChange(newList)
              }
            ) {
              Icon(
                Icons.Default.Close,
                contentDescription = "Remove $item",
                modifier = Modifier.size(18.dp)
              )
            }
          },
          modifier = Modifier.height(32.dp),
          colors = InputChipDefaults.inputChipColors(
            selectedContainerColor = Purple400,
            selectedLabelColor = White000,
            selectedLeadingIconColor = White000,
            selectedTrailingIconColor = White000
          )
        )
      }

    }

    Spacer(modifier = Modifier.height(8.dp))

  }

}