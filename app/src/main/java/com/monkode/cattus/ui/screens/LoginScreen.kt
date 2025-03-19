package com.monkode.cattus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.TextFieldDefaults
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.monkode.cattus.R

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_cattus),
            contentDescription = "Logo Cattus",
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 40.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Gray, // Cor de fundo desejada
                focusedBorderColor = Color.Blue, // Cor da borda quando focado
                unfocusedBorderColor = Color.Gray // Cor da borda quando não focado
            ),
            modifier = Modifier
                .width(300.dp)
                .background(color = Color.Gray),

            )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            modifier = Modifier
                .width(300.dp)
                .padding(top = 8.dp)
                .background(color = Color.Gray)
        )

        Button(
            onClick = { /* Lógica de login */ },
            modifier = Modifier
                .width(300.dp)
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4CAF50))
        ) {
            Text("Entrar", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}