package com.monkode.cattus.ui.screens.cat.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.monkode.cattus.R
import com.monkode.cattus.ui.components.misc.CustomButton
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.Green300
import com.monkode.cattus.ui.theme.White000

@Composable
fun HomeRegister(navController: NavController) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Black400)
      .padding(16.dp, 0.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Image(
      painter = painterResource(id = R.drawable.register_cat),
      contentDescription = "Register cat",
      modifier = Modifier.size(220.dp)
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
      "O que deseja fazer?",
      fontSize = 22.sp,
      style = TextStyle(color = White000, fontWeight = FontWeight.Bold)
    )

    Spacer(modifier = Modifier.height(12.dp))

    Box(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp)
    ) {
      Column {
        Text(
          "O cadastro de gatos possui 5 etapas. As duas primeiras são OBRIGATÓRIAS e inserem o gato no sistema, enquanto as últimas três são opcionais",
          style = TextStyle(color = White000),
          fontSize = 16.sp,
          textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
          "Cadastrar gato inicia um novo cadastro.\n" +
                  "Concluir cadastro retoma o registro de um gato já cadastrado.",
          style = TextStyle(color = White000),
          fontSize = 16.sp,
          textAlign = TextAlign.Center
        )
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    CustomButton(
      onClick = {
        navController.navigate("cat_register")
      },
      text = "Cadastrar",
      backgroundColor = Green300,
      //icon = Icons.Default.Plus
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
      "Concluir cadastro",
      style = TextStyle(color = White000, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    )

  }
}

/*
@Preview(showBackground = true)
@Composable
fun HomeRegisterPreview() {
    HomeRegister()
}
*/