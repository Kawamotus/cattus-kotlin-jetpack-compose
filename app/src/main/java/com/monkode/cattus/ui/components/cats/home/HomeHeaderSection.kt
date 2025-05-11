package com.monkode.cattus.ui.components.cats.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.R
import com.monkode.cattus.ui.theme.Black400

@Composable
fun HeaderSection() {
  Column (
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .fillMaxWidth()
      //.background(Brush.verticalGradient(colors = listOf(Color(0xFFC7F0D8), Color.White)))
  ) {

    // Avatar
    Image(
      painter = painterResource(id = R.drawable.profile_picture), // substitua pela sua imagem
      contentDescription = "Foto",
      modifier = Modifier
        .padding(top = 8.dp)
        .size(88.dp)
        .clip(CircleShape)
    )

    Text("Nome da instituição", style = TextStyle(fontSize = 20.sp, color = Black400, fontWeight = FontWeight.Bold))
    Text("Informação secundária", style = TextStyle(fontSize = 16.sp, color = Black400))

    Spacer(modifier = Modifier.height(32.dp))
    Box(modifier = Modifier.fillMaxWidth()){
      Text("Bem-vindo, Funcionário(a)!", style = TextStyle(fontSize = 20.sp, color = Black400, textAlign = TextAlign.Start))
    }

  }
}
