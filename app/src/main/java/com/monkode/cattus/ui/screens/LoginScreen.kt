package com.monkode.cattus.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.monkode.cattus.R

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_cattus),
            contentDescription = "Logo Cattus",
            modifier = Modifier.size(200.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Gray,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                textColor = Color.Black,
                cursorColor = Color.Black,
                focusedLabelColor = Color.White
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Gray,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                textColor = Color.Black,
                cursorColor = Color.Black,
                focusedLabelColor = Color.White
            )
        )

        Button(
            onClick = { /* Lógica de login */ },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .width(300.dp)
                .height(60.dp)
                .padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4CAF50),
                )
        ) {
            Text("Entrar", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}