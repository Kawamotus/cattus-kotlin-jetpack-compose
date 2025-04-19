package com.monkode.cattus.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import com.monkode.cattus.ui.components.BaseScreen
import com.monkode.cattus.ui.screens.mainscreens.*

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf("home") }

    BaseScreen(onNavItemClick = {route -> currentScreen = route}, currentScreen) {
        paddingValues ->
        Column {
            when (currentScreen) {
                "home" -> Home()
                "cats" -> CatsList()
                "add" -> AddCat()
                "cameras" -> CameraList()
                "menu" -> Menu()
            }
        }
    }
}
