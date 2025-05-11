package com.monkode.cattus.ui.components.cats.home

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.ui.theme.Green300
import com.monkode.cattus.ui.theme.Purple400
import com.monkode.cattus.ui.theme.White000

@Composable
fun ActionGrid() {
  val buttons = listOf(
    Pair("Lista de gatos", Icons.Default.Pets),
    Pair("Cadastrar gato", Icons.Default.Add),
    Pair("Câmeras", Icons.Default.Videocam),
    Pair("Marcações", Icons.Default.Star),
    Pair("Estatísticas", Icons.Default.BarChart),
    Pair("Relatórios", Icons.Default.Description)
  )

  Column(Modifier.padding()) {
    for (row in buttons.chunked(2)) {
      Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp)
      ) {
        for ((label, icon) in row) {
          Box(
            modifier = Modifier
              .padding()
              .clickable {}
              .weight(1f)
              .height(80.dp)
              .clip(RoundedCornerShape(8.dp))
              .background(Green300)) // verde
          {

            Box(modifier = Modifier.padding(8.dp)) {
              Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
              ) {
                Box(
                  modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Purple400)
                    .clickable(onClick = {}),
                  contentAlignment = Alignment.Center
                ) {
                  Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = White000,
                    modifier = Modifier.size(28.dp)
                  )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(label, color = White000, style = TextStyle(fontSize = 16.sp))
              }

            }
          }
        }
      }
    }
  }
}
