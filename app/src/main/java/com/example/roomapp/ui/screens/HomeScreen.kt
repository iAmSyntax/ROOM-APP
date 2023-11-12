package com.example.roomapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.roomapp.data.UserViewModel
import com.example.roomapp.ui.composeFunctions.CustomFloatingActionButton
import com.example.roomapp.ui.composeFunctions.RoomAppBar
import com.example.roomapp.ui.composeFunctions.UserDetailsList
import com.example.roomapp.ui.route.Screen

@Composable
fun HomeScreen(navController: NavController) {
    val userViewModel:UserViewModel = viewModel()
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        RoomAppBar()
        UserDetailsList(userViewModel = userViewModel)
        CustomFloatingActionButton(
            onClick = {
                // Handle button click
                navController.navigate(route = Screen.EnterDetails.route)
            }
        )
    }
}

