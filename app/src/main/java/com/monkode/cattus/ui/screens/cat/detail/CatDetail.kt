package com.monkode.cattus.ui.screens.cat.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.ui.components.cats.detail.CatProfileDetails
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.White000

@Composable
fun CatDetail(cat: CatData) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Black400)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
      AsyncImage(
        model = cat.petPicture,
        contentDescription = "petname",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
      )

      Column(
        modifier = Modifier
          .align(Alignment.BottomStart)
          .padding(16.dp)
      ) {
        Text(
          cat.petName ?: "Nome desconhecido",
          fontSize = 28.sp,
          fontWeight = FontWeight.Bold,
          color = White000
        )
        Text("idade do bicho", fontSize = 16.sp, color = White000)
      }
    }

    var selectedTab by remember { mutableStateOf(0) }
    TabRow(selectedTab, backgroundColor = Color.Transparent, contentColor = White000) {
      Tab(
        selected = selectedTab == 0,
        onClick = { selectedTab = 0 },
        text = { Text("Perfil", color = White000) },
      )
      Tab(
        selected = selectedTab == 1,
        onClick = { selectedTab = 1 },
        text = { Text("Atividades", color = White000) }
      )
    }

    when (selectedTab) {
      0 -> CatProfileDetails(cat)
      1 -> ""
    }
  }
}

