package com.monkode.cattus.ui.components.cameras

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.ui.theme.White000

@Composable
fun CameraCountAndSort(cameraQuantity: Int) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text("${cameraQuantity} câmeras no total", color = White000, fontSize = 20.sp)
    Icon(
      imageVector = Icons.Default.SwapVert,
      contentDescription = "Ordenar",
      tint = White000,
      modifier = Modifier.size(28.dp)
    )
  }
}
