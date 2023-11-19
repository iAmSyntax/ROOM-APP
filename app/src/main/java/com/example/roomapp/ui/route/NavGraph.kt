package com.example.roomapp.ui.route

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roomapp.ui.screens.EnterDetailsScreen
import com.example.roomapp.ui.screens.HomeScreen
import com.example.roomapp.ui.screens.UpdateDetailsScreen


@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    val sharedViewModel: SharedViewModel = viewModel()


    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController,sharedViewModel)
        }
        composable(route = Screen.EnterDetails.route) {
            EnterDetailsScreen(navController = navController)
        }
        composable(route = Screen.UpdateDetails.route) {
            UpdateDetailsScreen(navController = navController, sharedViewModel)
        }


    }

}

