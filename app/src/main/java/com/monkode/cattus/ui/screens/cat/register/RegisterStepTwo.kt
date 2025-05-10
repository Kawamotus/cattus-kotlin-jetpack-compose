package com.monkode.cattus.ui.screens.cat.register

import android.Manifest
import android.content.ContentValues
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.monkode.cattus.ui.components.CustomButton
import com.monkode.cattus.ui.theme.Gray100
import com.monkode.cattus.ui.theme.Gray400
import com.monkode.cattus.ui.theme.Purple400
import com.monkode.cattus.ui.theme.White000

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun RegisterStepTwo(
  onProceedClick: () -> Unit, onImageSelected: (Uri?) -> Unit
) {
  val context = LocalContext.current
  val imageUri = remember { mutableStateOf<Uri?>(null) }
  val cameraImageUri = remember { mutableStateOf<Uri?>(null) }

  val permissionLauncher = rememberLauncherForActivityResult(
    ActivityResultContracts.RequestMultiplePermissions()
  ) { permissions ->
    val granted = permissions[Manifest.permission.CAMERA] == true &&
            permissions[Manifest.permission.READ_EXTERNAL_STORAGE] == true
    if (!granted) {
      Toast.makeText(context, "Permissões não concedidas", Toast.LENGTH_SHORT).show()
    }
  }


  LaunchedEffect(Unit) {
    permissionLauncher.launch(
      arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE
      )
    )
  }

  val galleryLauncher = rememberLauncherForActivityResult(
    ActivityResultContracts.GetContent()
  ) { uri ->
    imageUri.value = uri
    onImageSelected(uri)
  }

  val cameraLauncher = rememberLauncherForActivityResult(
    ActivityResultContracts.TakePicture()
  ) { success ->
    if (success) {
      val uri = cameraImageUri.value
      imageUri.value = uri
      onImageSelected(uri)
    }
  }

  fun createImageUri(): Uri? {
    val resolver = context.contentResolver
    val contentValues = ContentValues().apply {
      put(MediaStore.MediaColumns.DISPLAY_NAME, "cat_${System.currentTimeMillis()}.jpg")
      put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
    }
    return resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
  }

  Step2Content(
    selectedImageUri = imageUri.value,
    onGalleryClick = {
      galleryLauncher.launch("image/*")
    },
    onCameraClick = {
      val uri = createImageUri()
      if (uri != null) {
        cameraImageUri.value = uri
        cameraLauncher.launch(uri)
      } else {
        Toast.makeText(context, "Erro ao criar URI", Toast.LENGTH_SHORT).show()
      }
    },
    onProceedClick = onProceedClick
  )

}

@Composable
fun Step2Content(
  selectedImageUri: Uri?,
  onGalleryClick: () -> Unit,
  onCameraClick: () -> Unit,
  onProceedClick: () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(24.dp),
    verticalArrangement = Arrangement.spacedBy(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = "Foto do gato (obrigatório)",
      style = (MaterialTheme.typography.h6),
      color = White000
    )

    Box(
      modifier = Modifier
        .size(300.dp)
        .clip(RoundedCornerShape(12.dp))
        .background(Gray400),
      contentAlignment = Alignment.Center
    ) {
      if (selectedImageUri != null) {
        Image(
          painter = rememberAsyncImagePainter(selectedImageUri),
          contentDescription = "Imagem selecionada",
          modifier = Modifier.fillMaxSize(),
          contentScale = ContentScale.Crop
        )
      } else {
        Icon(
          imageVector = Icons.Default.AddAPhoto,
          contentDescription = "Adicionar foto",
          tint = Gray100,
          modifier = Modifier.size(48.dp)
        )
      }
    }

    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
      CustomButton(
        onClick = onGalleryClick,
        text = "Galeria",
        modifier = Modifier.width(120.dp),
        backgroundColor = Purple400
      )
      CustomButton(
        onClick = onCameraClick,
        text = "Camera",
        modifier = Modifier.width(120.dp),
        backgroundColor = Purple400
      )
    }

    Spacer(modifier = Modifier.weight(1f))

    CustomButton(
      onClick = { onProceedClick() },
      //enabled = selectedImageUri != null,
      text = "Próximo"
    )
  }
}

@Preview
@Composable
fun PreviewRegisterStepTwo() {
  val fakeUri = Uri.parse("https://placekitten.com/200/200")
  Step2Content(
    selectedImageUri = fakeUri,
    onGalleryClick = {},
    onCameraClick = {},
    onProceedClick = {}
  )
}
