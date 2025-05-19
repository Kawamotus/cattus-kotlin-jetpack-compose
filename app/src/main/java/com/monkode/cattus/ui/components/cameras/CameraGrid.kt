package com.monkode.cattus.ui.components.cameras

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monkode.cattus.api.models.CameraData

@Composable
fun CameraGrid(cameras: List<CameraData>) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(3),
    modifier = Modifier.padding(8.dp),
    contentPadding = PaddingValues(4.dp)
  ) {
    items(cameras) { camera ->
      CameraCard(camera)
    }
  }
}