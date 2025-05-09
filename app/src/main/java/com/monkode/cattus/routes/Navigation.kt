package com.monkode.cattus.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.ui.screens.LoadingScreen
import com.monkode.cattus.ui.screens.LoginScreen
import com.monkode.cattus.ui.screens.MainScreen
import com.monkode.cattus.ui.screens.cat.register.HomeRegister
import com.monkode.cattus.ui.screens.cat.register.MainCatRegister

@Composable
fun Navigation() {
  val context = LocalContext.current
  val navController = rememberNavController()

  val isAuthenticated by produceState<Boolean?>(initialValue = null) {
    val sessionManager = SessionManager(context = context)
    value = sessionManager.isValidToken()
  }

  if (isAuthenticated == null) {
    LoadingScreen()
    return
  }

  val startDestination = if(isAuthenticated == true) "mainscreen" else "login"

  NavHost(navController = navController, startDestination = startDestination) {
    composable("login") {
      LoginScreen(navController)
    }
    composable("mainscreen") {
      MainScreen(navController)
    }
    composable("cat_register") {
      MainCatRegister(navController)
    }
  }
}
