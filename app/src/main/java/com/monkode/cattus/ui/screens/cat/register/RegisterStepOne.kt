package com.monkode.cattus.ui.screens.cat.register

import CustomOutlinedTextField
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.api.models.CatData
import com.monkode.cattus.ui.theme.Black400
import com.monkode.cattus.ui.theme.Gray100
import com.monkode.cattus.ui.theme.Gray400
import com.monkode.cattus.ui.theme.White000

@Composable
fun RegisterStepOne(
    catData: CatData,
    onDataChange: (CatData) -> Unit,
    onProceedClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black400)
            .padding(16.dp, 0.dp)
    ) {
        Text("Nome", style = TextStyle(color = White000, fontSize = 16.sp))
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = catData.petName ?: "",
            onValueChange = { newValue ->
                onDataChange(catData.copy(petName = newValue))
            },
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(
                    "ex: Mingau",
                    color = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth(),// Adicione padding horizontal ao campo
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF424242), // Exemplo: um cinza mais claro para o fundo do campo
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                textColor = Color.White,
                placeholderColor = Color.Gray
            )
            // ---------------------------------------------------------------------------------------
            // Outros parâmetros como keyboardOptions, singleLine, maxLines, visualTransformation etc.
        )
        Spacer(modifier = Modifier.height(4.dp))

    }
}