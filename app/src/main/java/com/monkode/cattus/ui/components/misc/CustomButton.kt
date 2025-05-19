package com.monkode.cattus.ui.components.misc

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.ui.theme.Green300
import com.monkode.cattus.ui.theme.White000

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = Green300,
    textColor: Color = Color.White,
    icon: ImageVector? = null,
    iconTint: Color = White000
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .width(300.dp)
            .height(60.dp)
            .padding(top = 8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
        ),
        enabled = enabled
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            Text(text, color = textColor, fontSize = 16.sp)
        }

    }
}