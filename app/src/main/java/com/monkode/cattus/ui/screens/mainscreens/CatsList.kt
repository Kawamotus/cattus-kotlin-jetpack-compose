package com.monkode.cattus.ui.screens.mainscreens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.monkode.cattus.api.viewmodel.GetAllCatsViewModel
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.ui.components.cat.list.CatGrid
import com.monkode.cattus.ui.screens.LoadingScreen
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.White000

@Composable
fun CatsList(navController: NavController, getAllCatsViewModel: GetAllCatsViewModel = viewModel()) {

    val cats by getAllCatsViewModel.catsResult.collectAsState()
    val context = LocalContext.current

    LaunchedEffect (Unit) {
        val sessionManager = SessionManager(context)
        val token = sessionManager.getToken()
        if (token != null) {
            getAllCatsViewModel.getCats(
                context = context,
                token = token,
                onError = { error ->
                    Log.e("LazyCardCat", "Erro ao carregar gatos: $error")
                }
            )
        } else {
            Log.e("LazyCardCat", "Token é nulo!")
        }
    }

    Column(
        Modifier.background(color = White000).fillMaxSize().background(Black400),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            cats == null -> {
                Log.d("LazyCardCat", "Mostrando estado de loading")
                LoadingScreen()
            }
            cats?.isEmpty() == true -> {
                Log.d("LazyCardCat", "Mostrando estado vazio")
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    androidx.compose.material3.Text("Nenhum gato encontrado")
                }
            }
            else -> {
                Log.d("LazyCardCat", "Mostrando lista de gatos")
                CatGrid(cats!!)
            }
        }
    }
}