package com.monkode.cattus.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.monkode.cattus.ui.screens.LoginScreen
import com.monkode.cattus.ui.screens.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }
        composable("mainscreen") {
            MainScreen()
        }
    }
}
