package com.monkode.cattus.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.monkode.cattus.ui.theme.Gray100
import com.monkode.cattus.ui.theme.Gray400


data class BottomNavItem(
    val name: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun BottomMenu(onNavItemClick: (String) -> Unit){
    //mudar itens, ta assim só pra testar
    val items = listOf(
        BottomNavItem("Início", Icons.Filled.Home, "home"),
        BottomNavItem("Gatos", Icons.Filled.Pets, "cats"),
        BottomNavItem("Adicionar", Icons.Filled.Add, "add"),
        BottomNavItem("Câmeras", Icons.Filled.Videocam, "cameras"),
        BottomNavItem("Menu", Icons.Filled.Menu, "menu")
    )

    BottomNavigation(backgroundColor = Gray400) {
        items.forEach{item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = false,
                onClick = {onNavItemClick(item.route)},
                selectedContentColor = Color.White,
                unselectedContentColor = Gray100
            )
        }
    }
}