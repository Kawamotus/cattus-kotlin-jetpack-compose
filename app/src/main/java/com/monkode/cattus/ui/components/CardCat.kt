package com.monkode.cattus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.monkode.cattus.ui.theme.Purple400
import com.monkode.cattus.ui.theme.White000

@Composable
fun CardCat() {
    val imgTest =
        "https://images.unsplash.com/photo-1543852786-1cf6624b9987?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Y2F0c3xlbnwwfHwwfHx8MA%3D%3D"
    Row(
        modifier = Modifier
            .width(300.dp)
            .padding(8.dp)
    ) {

        Card(shape = RoundedCornerShape(8.dp), modifier = Modifier.size(80.dp)) {
            AsyncImage(
                model = imgTest,
                contentDescription = "Cat picture",
                modifier = Modifier.fillMaxSize(),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text("Cat name", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("Gender, age", color = White000, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(24.dp)
                .background(Purple400, shape = CircleShape)
        )
    }
}