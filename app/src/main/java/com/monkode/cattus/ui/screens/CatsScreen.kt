package com.monkode.cattus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.monkode.cattus.ui.components.BottomMenu
import com.monkode.cattus.ui.theme.Black400

@Composable
fun CatsScreen(onNavItemClick: (String) -> Unit) {
    Scaffold(
        bottomBar = { BottomMenu(onNavItemClick = onNavItemClick) }, // Adicionado BottomMenu
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = Black400)
            ) {
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CatsScreenPreview() {
    CatsScreen(onNavItemClick = {})
}
