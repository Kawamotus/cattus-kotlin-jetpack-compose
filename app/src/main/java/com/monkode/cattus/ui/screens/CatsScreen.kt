package com.monkode.cattus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.monkode.cattus.ui.components.BottomMenu
import com.monkode.cattus.ui.components.CatsTopAppBar
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.Green300

@Composable
fun BaseScreen(
    onNavItemClick: (String) -> Unit,
    backgroundColor: Color = Black400,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { CatsTopAppBar() },
        bottomBar = { BottomMenu(onNavItemClick = onNavItemClick) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = backgroundColor)
            ) {
                content(paddingValues)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun BaseScreenPreview() {
    BaseScreen(onNavItemClick = {}, backgroundColor = Black400 ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text("Conteúdo da Tela")
            Text("Mais Conteúdo")
        }
    }
}
