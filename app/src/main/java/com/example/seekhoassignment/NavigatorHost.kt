package com.example.seekhoassignment

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.seekhoassignment.viewModel.AnimeViewModel

@Composable
fun NavigationStack(apiViewModel: AnimeViewModel, mainActivity: MainActivity) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable(route = "HomeScreen") {
            HomeScreen(mainActivity, navigationStack = navController,apiViewModel)
        }
        composable(route = "AnimeDetailScreen") {
            AnimeDetailScreen(mainActivity, navigationStack = navController,apiViewModel)
        }
    }
}