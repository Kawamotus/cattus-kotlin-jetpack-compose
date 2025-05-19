package com.monkode.cattus.ui.screens.mainscreens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.monkode.cattus.api.config.RetrofitClient
import com.monkode.cattus.api.interfaces.CatsApiService
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.api.repositories.CatsRepository
import com.monkode.cattus.api.viewmodel.GetAllCatsViewModel
import com.monkode.cattus.api.viewmodel.factory.GetAllCatsViewModelFactory
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.storage.UserDataManager
import com.monkode.cattus.ui.components.cats.list.CatFilterHeader
import com.monkode.cattus.ui.components.cats.list.CatGrid
import com.monkode.cattus.ui.screens.LoadingScreen
import com.monkode.cattus.ui.screens.cat.detail.CatDetail
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.White000

@Composable
fun CatsList(navController: NavController) {

  val context = LocalContext.current.applicationContext

  val getAllCatsService = RetrofitClient.getInstance(context).create(CatsApiService::class.java)
  val userDataManager = UserDataManager(context)
  val sessionManager = SessionManager(context)

  val repository = CatsRepository(getAllCatsService, userDataManager, sessionManager)
  val factory = GetAllCatsViewModelFactory(repository)

  val getAllCatsViewModel: GetAllCatsViewModel = viewModel(factory = factory)

  val uiState by getAllCatsViewModel.uiState.collectAsState()

  var selectedCat by remember { mutableStateOf<CatData?>(null) }

  LaunchedEffect(Unit) {
    getAllCatsViewModel.getCats()
  }

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Black400) // Cor de fundo da tela principal
  ) {
    Column(
      Modifier
        .background(color = White000)
        .fillMaxSize()
        .background(Black400),
      verticalArrangement = Arrangement.Center,
    ) {
      CatFilterHeader(
        selectedFilter = "Todos",
        resultCount = if (uiState is GetAllCatsViewModel.UiState.Success) (uiState as GetAllCatsViewModel.UiState.Success).cats.size else 0,
        onSearchClick = { /* lógica da busca */ },
        onFilterClick = { /* lógica do filtro */ },
        onFilterButtonClick = { /* abrir seleção de filtros */ }
      )
      when (uiState) {
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
            CatGrid(catsList) { cat ->
              selectedCat = cat
            }
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

    AnimatedVisibility(visible = selectedCat != null) {
      selectedCat?.let { cat ->
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Black400) //, shape = RoundedCornerShape(16.dp)
        ) {
          Box(modifier = Modifier.fillMaxSize()) {
            CatDetail(cat)
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopEnd)
                .padding(8.dp),
              horizontalArrangement = Arrangement.End
            ) {
              IconButton(onClick = { selectedCat = null }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Fechar", tint = White000)
              }
            }
          }
        }
      }
    }
  }



}