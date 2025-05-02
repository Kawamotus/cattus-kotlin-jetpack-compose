package com.monkode.cattus.ui.screens.cat.register

import RegisterTopAppBar
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.ui.components.BaseScreen
import com.monkode.cattus.ui.theme.Green300


@Composable
fun MainCatRegister() { //navController: NavController
    var step by remember { mutableStateOf(1) }
    var totalSteps by remember { mutableStateOf(5) }
    var currentStep by remember { mutableStateOf(0.0) }

    var catRegistrationData by remember { mutableStateOf(CatData()) }

    val progress = if (totalSteps > 0) currentStep.toFloat() / totalSteps else 0f

    BaseScreen(
        onNavItemClick = {},
        currentScreen = "add",
        topBar = {
            RegisterTopAppBar(
                title = "Cadastrar Gato",
                currentStep = step,
                totalSteps = 5,
                onBackClick = { step-- })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
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
            }
        }
    }
}

@Preview
@Composable
fun MainCatRegisterPreview() {
    MainCatRegister()
}
