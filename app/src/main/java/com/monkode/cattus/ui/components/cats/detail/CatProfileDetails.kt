package com.monkode.cattus.ui.components.cats.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monkode.cattus.api.models.CatData

@Composable
fun CatProfileDetails(cat: CatData){
  Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
    Text("Observacoes")
    Spacer(modifier = Modifier.height(8.dp))

    Text("Castrado")
    Text("Raca")
    Text("Tamanho")
    Spacer(modifier = Modifier.height(8.dp))

    Text("Pelagem")
    Text("Cor dos olhos")
    Text("Peso")
    Text("Altura")
    Spacer(modifier = Modifier.height(8.dp))

    Text("Comportamento")
    Text("Nivel de atividade")

  }
}