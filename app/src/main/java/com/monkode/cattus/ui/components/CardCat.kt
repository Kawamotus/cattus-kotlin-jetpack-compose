package com.monkode.cattus.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.api.viewmodel.GetAllCatsViewModel
import com.monkode.cattus.storage.SessionManager
import com.monkode.cattus.ui.screens.LoadingScreen
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.Purple400
import com.monkode.cattus.ui.theme.White000
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import com.monkode.cattus.R

@Composable
fun CardCat() { //passar os dados do gato como parametro pra montar o card
    val imgTest =
        "https://images.unsplash.com/photo-1543852786-1cf6624b9987?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Y2F0c3xlbnwwfHwwfHx8MA%3D%3D"

    Card( //adicionar parametros e deixar tudo dinâmico
        modifier = Modifier
            .padding(8.dp)
            .width(160.dp)
            .border(2.dp, Color.Green, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.height(180.dp).background(Black400)) {
            Image(
                painter = painterResource(id = (R.drawable.cat_test)),
                contentDescription = "miauuuu",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp))
            )

            Icon(
                imageVector = Icons.Default.Circle,
                contentDescription = "Estrela do pt",
                tint = Purple400, //colocar condicional pra favorito depois
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            )

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Estrela do pt",
                tint = Color.Yellow, //colocar condicional pra favorito depois
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(6.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black) // 👈 Aqui você muda a cor de fundo para preto
                .padding(8.dp)
        ) {
            Column(modifier = Modifier.padding(0.dp)) {
                Text("Nome do bicho", fontSize = 12.sp, style = TextStyle(color = White000))
                Text("Macho de 25 anos", fontSize = 12.sp, style = TextStyle(color = White000))
                Text("CID: Númerozao", fontSize = 12.sp, style = TextStyle(color = White000))
            }
        }




    }

}

@Preview
@Composable
fun CardCatPreview() {
    Column(modifier = Modifier.fillMaxSize().background(Black400)) {
        Row {
            CardCat()
            CardCat()
        }
        Row {
            CardCat()
            CardCat()
        }

    }

}

/*
@Composable
fun LazyCardCat(getAllCatsViewModel: GetAllCatsViewModel = viewModel()) {
    val cats by getAllCatsViewModel.catsResult.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
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

    Log.d("LazyCardCat", "Estado atual: ${if (cats == null) "Loading" else "Dados carregados (${cats?.size ?: 0} itens)"}")

    when {
        cats == null -> {
            Log.d("LazyCardCat", "Mostrando estado de loading")
            LoadingScreen()
        }
        cats?.isEmpty() == true -> {
            Log.d("LazyCardCat", "Mostrando estado vazio")
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Nenhum gato encontrado")
            }
        }
        else -> {
            Log.d("LazyCardCat", "Mostrando lista de gatos")
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .background(White000)
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                cats?.let { catList ->
                    items(catList.size) { index ->
                        CardCat(cat = catList[index])
                    }
                }
            }
        }
    }
}

*/