package com.monkode.cattus.ui.components.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.monkode.cattus.ui.theme.White000

@Composable
fun MenuItem(text: String, icon: ImageVector, onClick: () -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onClick() }
      .padding(12.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(icon, contentDescription = text, tint = White000)
    Spacer(Modifier.width(16.dp))
    Text(text, color = White000)
  }
}