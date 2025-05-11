package com.monkode.cattus.ui.components.cats.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.ui.theme.Gray400
import com.monkode.cattus.ui.theme.Green300
import com.monkode.cattus.ui.theme.White000

@Composable
fun HomeOccurrencesSection() {
  Column (
    modifier = Modifier
      .fillMaxWidth()
      .background(Gray400, shape = RoundedCornerShape(8.dp))
      .padding(16.dp)
  ) {
    Text("Ocorrências", color = White000, style = TextStyle(fontSize = 16.sp))

    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp),
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      val dias = listOf("D", "S", "T", "Q", "Q", "S", "S")
      dias.forEach {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Box(
            modifier = Modifier
              .size(24.dp)
              .border(2.dp, Green300, shape = CircleShape)
          )
          Text(it, color = White000, fontSize = 12.sp)
        }
      }
    }
  }
}
