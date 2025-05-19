package com.monkode.cattus.ui.components.cameras

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monkode.cattus.ui.theme.Gray100
import com.monkode.cattus.ui.theme.White000

@Composable
fun CameraFilters(selected: String = "Todas", onSelect: (String) -> Unit = {}) {
  val options = listOf("Todas", "Ativas", "Inativas")
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    options.forEach {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
          text = it,
          color = if (it == selected) White000 else Gray100
        )
        if (it == selected) {
          Box(
            modifier = Modifier
              .width(20.dp)
              .height(2.dp)
              .background(White000)
          )
        }
      }
    }
  }
}