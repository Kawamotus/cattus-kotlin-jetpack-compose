package com.monkode.cattus.ui.components.misc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ButtonDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.ui.theme.Green300
import com.monkode.cattus.ui.theme.White000
import java.math.RoundingMode

@Composable
fun IncrementDecrementField(
  label: String,
  value: Double,
  onValueChange: (Double) -> Unit,
  step: Double = 0.1,
  minValue: Double = 0.0,
  maxValue: Double = 999.0,
  buttonsBackgroundColor: Color = Green300,
  buttonsContentColor: Color = White000,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier.padding()) {
    Text(text = label, style = TextStyle(color = White000, fontSize = 16.sp))

    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
      modifier = Modifier
        .padding(top = 8.dp)
        .fillMaxWidth()
    ) {
      Button(
        onClick = {
          val newValue = (value - step).coerceAtLeast(minValue)
            .toBigDecimal().setScale(1, RoundingMode.HALF_UP).toDouble()
          onValueChange(newValue)
        },
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(36.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
          backgroundColor = buttonsBackgroundColor,
          contentColor = buttonsContentColor
        )
      ) {
        Text("-", style = TextStyle(fontSize = 20.sp))
      }

      Text(
        text = "%.1f".format(value),
        modifier = Modifier
          .padding(horizontal = 36.dp)
          .width(48.dp),
        textAlign = TextAlign.Center,
        style = TextStyle(color = White000, fontSize = 20.sp)
      )

      Button(
        onClick = {
          val newValue = (value + step).coerceAtMost(maxValue)
            .toBigDecimal().setScale(1, RoundingMode.HALF_UP).toDouble()
          onValueChange(newValue)
        },
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(36.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
          backgroundColor = buttonsBackgroundColor,
          contentColor = buttonsContentColor
        )
      ) {
        Text("+", style = TextStyle(fontSize = 20.sp))
      }
    }
  }
}


@Preview
@Composable
fun PreviewIncrementDecrement() {
  IncrementDecrementField("Tamanho", 0.6, onValueChange = {})
}
