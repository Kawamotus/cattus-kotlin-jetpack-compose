package com.monkode.cattus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.monkode.cattus.api.viewmodel.AuthViewModel
import com.monkode.cattus.api.viewmodel.UserDataViewModel
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager
import com.monkode.cattus.ui.components.misc.CustomButton
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel(),
    userViewModel: UserDataViewModel = viewModel()
) {
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }
    val userDataManager = remember { UserDataManager(context) }

    var isLoading by remember { mutableStateOf(false) }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val loginResult by authViewModel.loginResult.collectAsState()
    val userDataResult by userViewModel.userDataResult.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(loginResult) {
        loginResult?.let { response ->
            if (!response.token.isNullOrEmpty()) {
                sessionManager.saveToken(response.token)
                userViewModel.getUserData(response.token, context) { error ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(error)
                    }
                }
                navController.navigate("mainscreen") {
                    popUpTo("login") { inclusive = true }
                }
            } else {
                snackbarHostState.showSnackbar("Invalid Login")
            }
        }
    }

    LaunchedEffect(userDataResult) {
        userDataResult?.let { response ->
            if (!response.name.isNullOrEmpty()) {
                userDataManager.saveUserData(
                    response.id!!,
                    response.name,
                    response.picture!!,
                    response.accessLevel.toString()!!,
                    response.company!!
                )

            }
        }
    }



    if (isLoading) {
        LoadingScreen()
    } else {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Black400)
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
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
                    visualTransformation = PasswordVisualTransformation()
                )

                CustomButton(
                    onClick = {
                        isLoading = true
                        authViewModel.login(email, password, context) { error ->
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(error)
                                isLoading = false
                            }
                            isLoading = false
                        }
                    },
                    text = "Entrar",
                    backgroundColor = Green300
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}