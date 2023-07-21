package com.practical.videoplayer.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.practical.videoplayer.presentation.ui.screens.VideoListScreen
import com.practical.videoplayer.presentation.ui.screens.VideoPlayerScreen
import com.practical.videoplayer.presentation.view_model.VideoPlayerViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val viewModel: VideoPlayerViewModel = viewModel()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.VideoListScreen.route
    ) {


        composable(route = Screen.VideoListScreen.route) {
            VideoListScreen(navController, viewModel)
        }

        composable(route = Screen.VideoPlayerScreen.route) {
            VideoPlayerScreen(viewModel.selectedPath)
        }
    }
}