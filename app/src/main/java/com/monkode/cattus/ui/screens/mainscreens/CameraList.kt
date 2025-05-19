package com.monkode.cattus.ui.screens.mainscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.monkode.cattus.api.config.RetrofitClient
import com.monkode.cattus.api.interfaces.CamerasApiInterface
import com.monkode.cattus.api.repositories.CamerasRepository
import com.monkode.cattus.api.viewmodel.cameras.GetAllCamerasViewModel
import com.monkode.cattus.api.viewmodel.cats.GetOneCatViewModel
import com.monkode.cattus.api.viewmodel.factory.cameras.GetAllCamerasViewModelFactory
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager
import com.monkode.cattus.ui.components.cameras.CameraCountAndSort
import com.monkode.cattus.ui.components.cameras.CameraFilters
import com.monkode.cattus.ui.components.cameras.CameraGrid
import com.monkode.cattus.ui.screens.LoadingScreen
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.White000

@Composable
fun CameraList() {

    val context = LocalContext.current.applicationContext

    val getAllCamerasService = RetrofitClient.getInstance(context).create(CamerasApiInterface::class.java)
    val userDataManager = UserDataManager(context)
    val sessionManager = SessionManager(context)

    val repository = CamerasRepository(getAllCamerasService, userDataManager, sessionManager)
    val factory = GetAllCamerasViewModelFactory(repository)

    val getAllCamerasViewModel: GetAllCamerasViewModel = viewModel(factory = factory)

    val uiState by getAllCamerasViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        getAllCamerasViewModel.getCameras()
    }

    var cameraQuantity by remember { mutableStateOf(0) }

    Column(
        Modifier.background(color = Black400).fillMaxSize(),
    ) {
        //CameraFilters()
        CameraCountAndSort(cameraQuantity)
        when (uiState) {
            is GetAllCamerasViewModel.UiState.Idle -> LoadingScreen()
            is GetAllCamerasViewModel.UiState.Loading -> LoadingScreen()
            is GetAllCamerasViewModel.UiState.Success -> {
                val cameras = (uiState as GetAllCamerasViewModel.UiState.Success).cameras

                if(cameras.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Nenhuma camera encontrada")
                    }
                } else {
                    cameraQuantity = cameras.size
                    CameraGrid(cameras)
                }
            }
            is GetAllCamerasViewModel.UiState.Error -> Text("Nenhuma camera :(")
        }
    }
}