package com.monkode.cattus.ui.screens.cat.register

import RegisterTopAppBar
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.ui.components.BaseScreen
import com.monkode.cattus.ui.theme.Green300

@Composable
fun MainCatRegister(navController: NavController) {
  var step by remember { mutableStateOf(1) }
  var totalSteps by remember { mutableStateOf(5) }

  var currentScreen by remember { mutableStateOf("add") }

  var catRegistrationData by remember { mutableStateOf(CatData()) }
  var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

  val progress = if (totalSteps > 0) step.toFloat() / totalSteps else 0f

  BaseScreen(
    onNavItemClick = { route -> currentScreen = route },
    currentScreen = currentScreen,
    topBar = {
      RegisterTopAppBar(
        title = "Cadastrar Gato",
        currentStep = step,
        totalSteps = 5,
        onBackClick = {
          if (step > 1) step-- else {
            navController.navigate("mainscreen")
          }
        })
    }
  ) { paddingValues ->
    Column(modifier = Modifier.padding()) {
      Spacer(modifier = Modifier.height(16.dp))
      LinearProgressIndicator(
        progress = progress,
        color = Green300,
        modifier = Modifier
          .fillMaxWidth()
          .height(4.dp)
          .padding(16.dp, 0.dp)
      )
      Spacer(modifier = Modifier.height(16.dp))
      when (step) {
        1 -> RegisterStepOne(
          catData = catRegistrationData,
          onDataChange = { updatedData -> catRegistrationData = updatedData },
          onProceedClick = {
            if (step < totalSteps) {
              step++
            }
          })

        2 -> RegisterStepTwo(
          onProceedClick = {
            if (step < totalSteps) {
              step++
            }
          }, onImageSelected = { uri ->
            selectedImageUri = uri
          }
        )

        3 -> RegisterStepThree(
          catData = catRegistrationData,
          onDataChange = { updatedData -> catRegistrationData = updatedData },
          onProceedClick = {
            if (step < totalSteps) {
              step++
            }
          })

      }

    }
  }
}

