package com.monkode.cattus.ui.components.cats.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.monkode.cattus.R
import com.monkode.cattus.api.models.UserData
import com.monkode.cattus.storage.UserDataManager
import com.monkode.cattus.ui.theme.Black400

@Composable
fun HeaderSection() {

  val context = LocalContext.current
  val userDataManager = UserDataManager(context)

  val userData: UserData? by produceState<UserData?>(initialValue = null) {
    value = userDataManager.getUserData()
  }

  Column (
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .fillMaxWidth()
      //.background(Brush.verticalGradient(colors = listOf(Color(0xFFC7F0D8), Color.White)))
  ) {

    AsyncImage(
      model = userData?.picture ?: "https://res.cloudinary.com/teepublic/image/private/s--lk9qHiVL--/c_crop,x_10,y_10/c_fit,h_1109/c_crop,g_north_west,h_1260,w_840,x_-50,y_-77/co_rgb:000000,e_colorize,u_Misc:One%20Pixel%20Gray/c_scale,g_north_west,h_1260,w_840/fl_layer_apply,g_north_west,x_-50,y_-77/bo_0px_solid_white/e_overlay,fl_layer_apply,h_1260,l_Misc:Poster%20Bumpmap,w_840/e_shadow,x_6,y_6/c_limit,h_1254,w_1254/c_lpad,g_center,h_1260,w_1260/b_rgb:eeeeee/c_limit,f_auto,h_630,q_auto:good:420,w_630/v1611926063/production/designs/18989320_0.jpg",
      contentDescription = userData?.name ?: "nome do funcionario",
      modifier = Modifier
        .padding(top = 8.dp)
        .size(88.dp)
        .clip(CircleShape)
    )

    /*
    Image(
      painter = painterResource(id = R.drawable.profile_picture), // substitua pela sua imagem
      contentDescription = "Foto",
      modifier = Modifier
        .padding(top = 8.dp)
        .size(88.dp)
        .clip(CircleShape)
    ) */

    Text(userData?.name ?: "Nome da instituição", style = TextStyle(fontSize = 20.sp, color = Black400, fontWeight = FontWeight.Bold))
    Text("Nivel de acesso: ${userData?.accessLevel}", style = TextStyle(fontSize = 16.sp, color = Black400))

    Spacer(modifier = Modifier.height(32.dp))
    Box(modifier = Modifier.fillMaxWidth()){
      Text("Bem-vindo, ${userData?.name ?: "Colaborador"}!", style = TextStyle(fontSize = 20.sp, color = Black400, textAlign = TextAlign.Start))
    }

  }
}
