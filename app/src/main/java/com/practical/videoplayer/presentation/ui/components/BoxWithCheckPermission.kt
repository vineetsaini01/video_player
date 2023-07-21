package com.practical.videoplayer.presentation.ui.components

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.core.content.ContextCompat

@Composable
fun BoxWithCheckPermission(modifier: Modifier= Modifier, content: @Composable () -> Unit) {
    val context = LocalContext.current

    var hasPhoneStatePermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val phoneStatePermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        hasPhoneStatePermission = isGranted
    }

    LaunchedEffect(hasPhoneStatePermission) {
        if (!hasPhoneStatePermission) {
            phoneStatePermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    Box(
        modifier = modifier
    ) {
        if (hasPhoneStatePermission) content()
        else Text(
            modifier = Modifier.fillMaxSize(),
            text = "Please Grant Permission",
            textAlign = TextAlign.Center
        )
    }
}


