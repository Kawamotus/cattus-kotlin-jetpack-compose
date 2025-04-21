package com.monkode.cattus.ui.screens.mainscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.monkode.cattus.api.models.UserData
import com.monkode.cattus.ui.theme.White000
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager

@Composable
fun Home() {
    val context = LocalContext.current
    val sessionManager = SessionManager(context)
    val userDataManager = UserDataManager(context)

    var token by remember { mutableStateOf<String?>(null) }
    var userData by remember { mutableStateOf<UserData?>(null) }

    LaunchedEffect(Unit) {
        token = sessionManager.getToken().toString()
        userData = userDataManager.getUserData()
    }

    Column(
        Modifier.background(color = White000).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen, token = ${token}")
        Text("Home Screen, Name = ${userData?.name}")
    }
}