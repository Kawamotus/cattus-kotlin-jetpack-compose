package com.monkode.cattus.ui.components.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.R

@Composable
fun HomeTopAppBar() {
  Row(
    modifier = Modifier
      .statusBarsPadding()
      .fillMaxWidth()
      .height(56.dp)
      .background(
        Brush.verticalGradient(
          colors = listOf(Color(0xFFE9F7EC), Color(0xFFE9F7EC))
        )
      )
      .padding(horizontal = 16.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Image(
      painter = painterResource(R.drawable.cattus_hometopappbar),
      contentDescription = "Logo da Cattus",
      modifier = Modifier.size(100.dp)
    )

    // Sino com badge
    Box {
      Icon(
        imageVector = Icons.Default.Notifications,
        contentDescription = "Notificações",
        modifier = Modifier.size(28.dp),
        tint = Color.Black
      )

      // Badge vermelho
      Box(
        modifier = Modifier
          .size(16.dp)
          .offset(x = 10.dp, y = (-4).dp)
          .background(Color.Red, shape = CircleShape),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = "4",
          color = Color.White,
          fontSize = 10.sp,
          fontWeight = FontWeight.Bold
        )
      }
    }
  }
}


@Preview
@Composable
fun PreviewHomeTopAppBar() {
  HomeTopAppBar()
}
