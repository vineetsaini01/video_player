package com.practical.videoplayer.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.practical.videoplayer.presentation.ui.components.BoxWithCheckPermission
import com.practical.videoplayer.presentation.ui.components.VideoItem
import com.practical.videoplayer.presentation.ui.navigation.Screen
import com.practical.videoplayer.presentation.view_model.VideoPlayerViewModel
import com.practical.videoplayer.utils.VideosStorage.getVideosFromStorage


@Composable
fun VideoListScreen(navController: NavHostController, viewModel: VideoPlayerViewModel) {

    BoxWithCheckPermission(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        val videosList = getVideosFromStorage(context)

        if(videosList.isNotEmpty()){
            LazyColumn {
                items(videosList) { video ->
                    Column {
                        VideoItem(video) {
                            viewModel.selectedPath = video.uri
                            navController.navigate(Screen.VideoPlayerScreen.route)
                        }
                        Divider()
                    }

                }
            }
        }
        else{
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "No Record Found")
            }
        }
    }
}




