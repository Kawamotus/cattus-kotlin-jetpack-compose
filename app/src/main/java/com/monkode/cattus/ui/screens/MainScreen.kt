package com.monkode.cattus.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize // Importar fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier // Importar Modifier
import androidx.navigation.NavController
import com.monkode.cattus.ui.components.structure.BaseScreen
import com.monkode.cattus.ui.components.structure.topbar.DefaultTopAppBar
import com.monkode.cattus.ui.components.structure.topbar.HomeTopAppBar
import com.monkode.cattus.ui.screens.mainscreens.*

@Composable
fun MainScreen(navController: NavController, selectedScreen: String = "home") {
  var currentScreen by remember { mutableStateOf(selectedScreen) }
  var showMenu by remember { mutableStateOf(false) }

  BaseScreen(
    onNavItemClick = { route ->
      if (route == "menu") {
        showMenu = true
      } else {
        currentScreen = route
        showMenu = false
      }
    },
    currentScreen = currentScreen,
    topBar = {
      if (currentScreen == "home") HomeTopAppBar() else DefaultTopAppBar(
        when (currentScreen) {
          "cats" -> "Gatos"
          "add" -> "Cadastrar Gato"
          "cameras" -> "Cameras"
          else -> "Home"
        }
      )
    }
  ) { paddingValues ->
    Box(modifier = Modifier.fillMaxSize()) {
      Column(modifier = Modifier.fillMaxSize()) {
        when (currentScreen) {
          "home" -> Home()
          "cats" -> CatsList(navController)
          "add" -> AddCat(navController)
          "cameras" -> CameraList()
        }
      }

      AnimatedVisibility(
        visible = showMenu,
        enter = slideInHorizontally(
          initialOffsetX = { fullWidth -> fullWidth },
          animationSpec = tween(300)
        ),
        exit = slideOutHorizontally(
          targetOffsetX = { fullWidth -> fullWidth },
          animationSpec = tween(300)
        )
      ) {
        Menu(onClose = { showMenu = false }, navController)
      }
    }
  }
}