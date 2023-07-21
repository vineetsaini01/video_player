package com.practical.videoplayer.presentation.ui.navigation

sealed class Screen(val route: String) {
    object VideoListScreen : Screen(route = "VideoListScreen")
    object VideoPlayerScreen : Screen("VideoPlayerScreen")
}
