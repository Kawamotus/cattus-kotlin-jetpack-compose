package com.monkode.cattus.ui.screens.mainscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.monkode.cattus.api.config.RetrofitClient
import com.monkode.cattus.api.interfaces.CatsApiService
import com.monkode.cattus.api.repositories.CatsRepository
import com.monkode.cattus.api.viewmodel.cats.GetOneCatViewModel
import com.monkode.cattus.api.viewmodel.factory.cats.GetOneCatViewModelFactory
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager
import com.monkode.cattus.ui.screens.LoadingScreen
import com.monkode.cattus.ui.theme.White000

@Composable
fun CameraList() {

    val context = LocalContext.current.applicationContext

    val getOneCatService = RetrofitClient.getInstance(context).create(CatsApiService::class.java)
    val userDataManager = UserDataManager(context)
    val sessionManager = SessionManager(context)

    val repository = CatsRepository(getOneCatService, userDataManager, sessionManager)
    val factory = GetOneCatViewModelFactory(repository)

    val getOneCatViewModel: GetOneCatViewModel = viewModel(factory = factory)

    val uiState by getOneCatViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        getOneCatViewModel.loadCatDetails("6737d3941745304981dba463")
    }

    Column(
        Modifier.background(color = White000).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Camera List")
        when (uiState) {
            is GetOneCatViewModel.CatDetailsUiState.Idle -> LoadingScreen()
            is GetOneCatViewModel.CatDetailsUiState.Loading -> LoadingScreen()
            is GetOneCatViewModel.CatDetailsUiState.Success -> {
                val cat = (uiState as GetOneCatViewModel.CatDetailsUiState.Success).cat
                Text("${cat.petName}")
            }
            is GetOneCatViewModel.CatDetailsUiState.Error -> Text("Nenhum gatinho :(")
        }
    }
}