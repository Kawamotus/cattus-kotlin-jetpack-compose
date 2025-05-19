package com.monkode.cattus.ui.components.cameras

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.R
import com.monkode.cattus.api.models.CameraData
import com.monkode.cattus.ui.theme.White000

@Composable
fun CameraCard(camera: CameraData) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .padding(4.dp)
      .clip(RoundedCornerShape(8.dp))
      .clickable {}
  ) {
    Image(
      painter = painterResource(id = R.drawable.cameraicon),
      contentDescription = "camera title",
      modifier = Modifier
        .size(100.dp)
        .clip(RoundedCornerShape(8.dp)),
      contentScale = ContentScale.Crop
    )
    Text(
      text = camera.cameraLocation ?: "Local desconhecido",
      color = White000,
      fontSize = 12.sp,
      modifier = Modifier.padding(top = 4.dp)
    )
  }
}