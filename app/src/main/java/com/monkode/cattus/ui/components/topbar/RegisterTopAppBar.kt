import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monkode.cattus.ui.theme.Black400

@Composable
fun RegisterTopAppBar(
    title: String,
    currentStep: Int,
    totalSteps: Int,
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(Black400)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Go back",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .clickable { onBackClick() }
        )

        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.weight(1f).padding(start = 16.dp),
        )

        Text(
            text = "$currentStep/$totalSteps",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun RegisterTopAppBarPreview(){
    RegisterTopAppBar("Cadastro de Gatos", 1, 2, onBackClick = {})
}
