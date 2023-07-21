package com.practical.videoplayer.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun VideoPlayerScreen(uri: String?) {
    val context = LocalContext.current
    val exoPlayer = remember { SimpleExoPlayer.Builder(context).build() }

    DisposableEffect(uri) {
        val mediaItem = uri?.let { MediaItem.fromUri(it) }
        if (mediaItem != null) {
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.playWhenReady = true // Autoplay when ready
            exoPlayer.prepare()
        }

        // Ensure the player is released when the composable is disposed
        onDispose {
            exoPlayer.stop()
            exoPlayer.release()
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(color = Color.Black)) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                PlayerView(context).apply {
                    player = exoPlayer
                }
            },
        )
    }
}






