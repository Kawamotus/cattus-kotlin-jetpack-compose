package com.monkode.cattus.ui.screens.mainscreens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.monkode.cattus.api.models.UserData
import com.monkode.cattus.ui.theme.White000
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager
import com.monkode.cattus.ui.components.cats.home.ActionGrid
import com.monkode.cattus.ui.components.cats.home.HeaderSection
import com.monkode.cattus.ui.components.cats.home.HomeOccurrencesSection

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

  Box(modifier = Modifier.fillMaxSize()) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.4f) // ~2/5 da altura
        .background(
          Brush.verticalGradient(
            colors = listOf(
              Color(0xFFE9F7EC), // Verde claro
              Color.White
            )
          )
        )
    )

    Column(modifier = Modifier
      .padding(start = 16.dp, end = 16.dp)
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      ) {
      HeaderSection()
      Spacer(modifier = Modifier.height(8.dp))
      HomeOccurrencesSection()
      Spacer(modifier = Modifier.height(8.dp))
      ActionGrid()
    }

  }
}