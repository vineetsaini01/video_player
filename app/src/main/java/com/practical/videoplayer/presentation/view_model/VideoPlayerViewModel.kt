package com.practical.videoplayer.presentation.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class VideoPlayerViewModel : ViewModel() {
    var selectedPath by mutableStateOf("")
}
