package com.monkode.cattus.ui.screens.mainscreens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.monkode.cattus.api.config.RetrofitClient
import com.monkode.cattus.api.interfaces.GetAllCatsInterface
import com.monkode.cattus.api.repositories.CatsRepository
import com.monkode.cattus.api.viewmodel.GetAllCatsViewModel
import com.monkode.cattus.api.viewmodel.GetAllCatsViewModelFactory
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager
import com.monkode.cattus.ui.components.cats.list.CatFilterHeader
import com.monkode.cattus.ui.components.cats.list.CatGrid
import com.monkode.cattus.ui.screens.LoadingScreen
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.White000

@Composable
fun CatsList(navController: NavController) {

    val context = LocalContext.current.applicationContext

    val apiService = RetrofitClient.getInstance(context).create(GetAllCatsInterface::class.java)
    val userDataManager = UserDataManager(context)
    val sessionManager = SessionManager(context)

    val repository = CatsRepository(apiService, userDataManager, sessionManager)
    val factory = GetAllCatsViewModelFactory(repository)

    val getAllCatsViewModel: GetAllCatsViewModel = viewModel(factory = factory)

    val uiState by getAllCatsViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        getAllCatsViewModel.getCats()
    }

    Column(
        Modifier.background(color = White000).fillMaxSize().background(Black400),
        verticalArrangement = Arrangement.Center,
    ) {
        CatFilterHeader(
            selectedFilter = "Todos",
            resultCount = if (uiState is GetAllCatsViewModel.UiState.Success) (uiState as GetAllCatsViewModel.UiState.Success).cats.size else 0,
            onSearchClick = { /* lógica da busca */ },
            onFilterClick = { /* lógica do filtro */ },
            onFilterButtonClick = { /* abrir seleção de filtros */ }
        )
        when(uiState) {
            is GetAllCatsViewModel.UiState.Idle -> {
                LoadingScreen()
            }
            is GetAllCatsViewModel.UiState.Loading -> {
                LoadingScreen()
            }
            is GetAllCatsViewModel.UiState.Success -> {
                val catsList = (uiState as GetAllCatsViewModel.UiState.Success).cats
                if (catsList.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Nenhum gato encontrado")
                    }
                } else {
                    CatGrid(catsList)
                }
            }
            is GetAllCatsViewModel.UiState.Error -> {
                val errorMessage = (uiState as GetAllCatsViewModel.UiState.Error).message
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Erro ao carregar gatos: $errorMessage")
                }
                Log.e("CatsList", "Erro no ViewModel state: $errorMessage")
            }
        }
    }
}