package com.monkode.cattus.ui.components.cats.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ButtonDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.White000

@Composable
fun CatFilterHeader(
  selectedFilter: String = "Todos",
  resultCount: Int,
  onSearchClick: () -> Unit,
  onFilterClick: () -> Unit,
  onFilterButtonClick: () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 8.dp)
  ) {
    // Linha 1: ícones à direita
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.End,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(36.dp)
          .clip(CircleShape)
          .background(White000)
          .clickable(onClick = {}),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.Default.Search,
          contentDescription = null,
          tint = Black400
        )
      }

      Spacer(modifier = Modifier.width(8.dp))

      Box(
        modifier = Modifier
          .size(36.dp)
          .clip(CircleShape)
          .background(White000)
          .clickable(onClick = {}),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          imageVector = Icons.Default.FilterList,
          contentDescription = null,
          tint = Black400
        )
      }
    }

    Spacer(modifier = Modifier.height(8.dp))

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Button(
        onClick = onFilterButtonClick,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
          backgroundColor = White000,
          contentColor = Black400
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
        elevation = ButtonDefaults.elevation(0.dp)
      ) {
        Text(
          text = selectedFilter,
          style = TextStyle(fontSize = 16.sp, color = Black400)
        )
      }

      Text(
        text = "Exibindo $resultCount resultados",
        style = TextStyle(fontSize = 16.sp, color = White000)
      )
    }
  }
}


@Preview
@Composable
fun PreviewCatFilterHeader() {
  CatFilterHeader(
    selectedFilter = "Todos", //criar um val filter e selecionar de acordo com ele
    resultCount = 6,
    onSearchClick = { /* lógica da busca */ },
    onFilterClick = { /* lógica do filtro */ },
    onFilterButtonClick = { /* abrir seleção de filtros */ }
  )
}
