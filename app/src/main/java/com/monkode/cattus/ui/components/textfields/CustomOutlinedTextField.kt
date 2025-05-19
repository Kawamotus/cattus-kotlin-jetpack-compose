import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.VisualTransformation
import com.monkode.cattus.ui.theme.Gray100
import com.monkode.cattus.ui.theme.Gray400

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    width: Int = 300,
    placeholder: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default.copy(fontSize = 18.sp)
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.width(width.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Gray400,
            focusedBorderColor = Gray400,
            unfocusedBorderColor = Gray400,
            textColor = Gray100,
            cursorColor = Gray100,
            focusedLabelColor = Gray100,
            unfocusedLabelColor = Gray100,
            placeholderColor = Gray100
        ),
        textStyle = textStyle,
        visualTransformation = visualTransformation,
        placeholder = { Text(placeholder) }
    )
}
