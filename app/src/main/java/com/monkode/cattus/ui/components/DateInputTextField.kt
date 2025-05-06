package com.monkode.cattus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.monkode.cattus.ui.theme.Gray100
import com.monkode.cattus.ui.theme.Gray400
import com.monkode.cattus.ui.theme.White000

@Composable
fun DateInputField(
    value: String,
    onClick: () -> Unit,
    placeholder: String = "dd/mm/aaaa"
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Gray400, RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = if (value.isNotEmpty()) value else placeholder,
            color = if (value.isNotEmpty()) White000 else Gray100
        )
        Icon(
            imageVector = Icons.Default.CalendarMonth,
            contentDescription = "Ícone de calendário",
            tint = White000,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}
