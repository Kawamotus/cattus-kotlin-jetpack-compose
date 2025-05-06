package com.monkode.cattus.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.monkode.cattus.ui.theme.Gray100

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholderText: String? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = label?.let { { Text(it) } },
        placeholder = placeholderText?.let {
            {
                Text(
                    it,
                    color = Gray100
                )
            }
        },
        shape = RoundedCornerShape(8.dp),
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF424242),
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            textColor = Color.White,
            placeholderColor = Color.Gray
        ),
        trailingIcon = trailingIcon,
        readOnly = readOnly,
        enabled = enabled
    )
}