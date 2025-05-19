package com.monkode.cattus.ui.components.cats.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.monkode.cattus.ui.theme.White000

@Composable
fun DetailSectionTitle(title: String) {
  Text(
    text = title,
    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold),
    modifier = Modifier.padding(vertical = 4.dp),
    color = White000
  )
}
