package com.monkode.cattus.ui.screens.mainscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.monkode.cattus.ui.screens.cat.register.HomeRegister
import com.monkode.cattus.ui.theme.Purple400
import com.monkode.cattus.ui.theme.White000

@Composable
fun AddCat(navController: NavController) {
    HomeRegister(navController)
}