package com.monkode.cattus.ui.screens.mainscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.monkode.cattus.ui.components.menu.MenuItem
import com.monkode.cattus.ui.theme.White000

@Composable
fun Menu(onClose: () -> Unit, navController: NavController) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xAA000000))
      .clickable(onClick = onClose),
    contentAlignment = Alignment.CenterEnd
  ) {
    Box(
      modifier = Modifier
        .fillMaxHeight()
        .width(300.dp)
        .background(Color(0xFF3A3A3A))
    ) {
      Column(modifier = Modifier.padding(16.dp)) {
        IconButton(onClick = onClose, modifier = Modifier.align(Alignment.End)) {
          Icon(Icons.Default.Close, contentDescription = "Fechar", tint = Color.White)
        }

        Text("Nome completo", color = Color.White, style = MaterialTheme.typography.h6)
        Text("Editar Perfil", color = Color.LightGray)

        Spacer(Modifier.height(20.dp))
        Divider(color = Color.Gray)

        MenuItem("Início", Icons.Default.Home) { }
        MenuItem(
          "Lista de gatos",
          Icons.Default.Pets
        ) {} //{ navController.navigate("cats"); onClose() }
        MenuItem("Cadastrar gatos", Icons.Default.Add) {  }
        MenuItem("Câmeras", Icons.Default.Videocam) {  }
      }
    }
  }
}