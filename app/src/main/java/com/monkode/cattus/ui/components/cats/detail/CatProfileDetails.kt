package com.monkode.cattus.ui.components.cats.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monkode.cattus.api.models.CatData

@Composable
fun CatProfileDetails(cat: CatData) {
  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.Top
  ) {
    item {
      DetailSection(
        title = "Informações Gerais",
        items = listOf(
          Triple(Icons.Default.Pets, "Observações", cat.petObs ?: "Nenhuma"),
          Triple(Icons.Default.Male, "Sexo", cat.petGender ?: "Desconhecido")
        )
      )
    }

    item {
      DetailSection(
        title = "Características Físicas",
        items = listOf(
          Triple(Icons.Default.Palette, "Pelagem", "${cat.physicalCharacteristics?.furColor ?: "N/A"} - ${cat.physicalCharacteristics?.furLength ?: "N/A"}"),
          Triple(Icons.Default.RemoveRedEye, "Cor dos olhos", cat.physicalCharacteristics?.eyeColor ?: "N/A"),
          Triple(Icons.Default.MonitorWeight, "Peso", "${cat.physicalCharacteristics?.weight ?: 0.0} kg"),
          Triple(Icons.Default.Height, "Altura", "${cat.physicalCharacteristics?.size ?: 0.0} cm")
        )
      )
    }

    item {
      DetailSection(
        title = "Comportamento",
        items = listOf(
          Triple(Icons.Default.Face, "Personalidade", cat.behavioralCharacteristics?.personality ?: "N/A"),
          Triple(Icons.Default.FitnessCenter, "Nível de Atividade", cat.behavioralCharacteristics?.activityLevel ?: "N/A")
        )
      )
    }

    item {
      DetailSection(
        title = "Outros",
        items = listOf(
          Triple(Icons.Default.CheckCircle, "Castrado", cat.petCharacteristics?.petCastrated ?: "Desconhecido"),
          Triple(Icons.Default.Pets, "Raça", cat.petCharacteristics?.petBreed ?: "Desconhecida"),
          Triple(Icons.Default.Height, "Tamanho", cat.petCharacteristics?.petSize ?: "Desconhecido")
        )
      )
    }
  }
}
