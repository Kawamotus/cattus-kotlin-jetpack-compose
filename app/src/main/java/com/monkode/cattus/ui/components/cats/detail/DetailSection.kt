package com.monkode.cattus.ui.components.cats.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DetailSection(title: String, items: List<Triple<ImageVector, String, String>>) {
  Column(modifier = Modifier.padding(top = 12.dp)) {
    DetailSectionTitle(title)
    items.forEach { (icon, label, value) ->
      DetailCard(icon = icon, label = label, value = value)
    }
  }
}