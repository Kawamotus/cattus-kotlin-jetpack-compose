package com.monkode.cattus.ui.screens

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
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.Green300
import CustomOutlinedTextField
import com.monkode.cattus.ui.components.CustomButton
import com.monkode.cattus.ui.theme.Purple400

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black400)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_cattus),
            contentDescription = "Logo Cattus",
            modifier = Modifier.size(200.dp)
        )

        CustomOutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = "E-mail",
        )

        CustomOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = "Senha",
        )

        CustomButton(onClick = {}, text = "Entrar", backgroundColor = Green300)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}