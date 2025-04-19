package com.monkode.cattus.ui.components

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
fun BottomMenu(onNavItemClick: (String) -> Unit, currentScreen: String = ""){
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
                modifier = Modifier.padding(bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()),
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = currentScreen == item.route,
                onClick = {onNavItemClick(item.route)},
                selectedContentColor = Color.White,
                unselectedContentColor = Gray100
            )
        }
    }
}