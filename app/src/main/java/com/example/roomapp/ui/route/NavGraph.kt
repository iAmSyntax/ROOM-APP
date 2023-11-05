package com.example.roomapp.ui.route

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roomapp.data.UserViewModel
import com.example.roomapp.ui.screens.EnterDetailsScreen
import com.example.roomapp.ui.screens.HomeScreen


@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController=navController)
        }
        composable(route=Screen.EnterDetails.route){
            EnterDetailsScreen(navController=navController)
        }
    }

}