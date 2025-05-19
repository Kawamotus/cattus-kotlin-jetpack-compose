package com.monkode.cattus.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.monkode.cattus.ui.components.structure.BaseScreen
import com.monkode.cattus.ui.components.structure.topbar.DefaultTopAppBar
import com.monkode.cattus.ui.components.structure.topbar.HomeTopAppBar
import com.monkode.cattus.ui.screens.mainscreens.*

@Composable
fun MainScreen(navController: NavController) {
  var currentScreen by remember { mutableStateOf("home") }

  BaseScreen(onNavItemClick = { route -> currentScreen = route }, currentScreen, topBar = {
    if (currentScreen == "home") HomeTopAppBar() else DefaultTopAppBar(
      when (currentScreen) {
        "home" -> "Home"
        "cats" -> "Gatos"
        "add" -> "Cadastrar Gato"
        "cameras" -> "Cameras"
        "menu" -> "Menu"
        else -> "Home"
      }
    )
  }) { paddingValues ->
    Column {
      when (currentScreen) {
        "home" -> Home()
        "cats" -> CatsList(navController)
        "add" -> AddCat(navController)
        "cameras" -> CameraList()
        "menu" -> Menu()
      }
    }
  }
}
