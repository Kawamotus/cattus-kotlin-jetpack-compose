package com.monkode.cattus.api.utils

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

fun uriToFile(uri: Uri, context: Context): File? {
  val contentResolver = context.contentResolver
  val fileName = getFileName(contentResolver, uri) ?: return null
  val file = File(context.cacheDir, fileName)
  try {
    contentResolver.openInputStream(uri)?.use { inputStream ->
      FileOutputStream(file).use { outputStream ->
        inputStream.copyTo(outputStream)
      }
    }
  } catch (e: Exception) {
    e.printStackTrace()
    return null
  }
  return file
}

private fun getFileName(contentResolver: android.content.ContentResolver, uri: Uri): String? {
  var name: String? = null
  val cursor = contentResolver.query(uri, null, null, null, null)
  cursor?.use {
    if (it.moveToFirst()) {
      val nameIndex = it.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
      if (nameIndex != -1) {
        name = it.getString(nameIndex)
      }
    }
  }
  return name
}
