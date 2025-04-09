package com.monkode.cattus.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Badge
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BadgedBox
import androidx.compose.material.Colors
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.monkode.cattus.R
import com.monkode.cattus.ui.theme.Black400
import androidx.compose.ui.graphics.Color

@Composable
fun CatsTopAppBar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_picture), //deixar dinamico
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(
                            CircleShape
                        )
                )
                Text("Gatinhos miau", color = Color.White) //deixar dinamico
            }
        },
        actions = {
//            IconButton(onClick = { /* deixar dinamico */ }) {
//                Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
//            }
//            IconButton(onClick = { /* deixar dinamico */ }) {
//                Icon(Icons.Filled.Tune, contentDescription = "Filter", tint = Color.White)
//            }
            BadgedBox(
                badge = {
                    Badge(modifier = Modifier.offset(x = (-16.dp), y = 12.dp)) {
                        Text("4")
                    }
                }
            ) {
                IconButton(onClick = { /* deixar dinamico */ }) {
                    Icon(
                        Icons.Filled.Notifications,
                        contentDescription = "Notificações",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        },
        backgroundColor = Black400,
        elevation = 4.dp
    )
}

@Preview(showBackground = true)
@Composable
fun CatsTopAppBarPreview() {
    CatsTopAppBar()
}