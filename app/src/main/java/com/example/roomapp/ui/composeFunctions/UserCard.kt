package com.example.roomapp.ui.composeFunctions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roomapp.data.User
import com.example.roomapp.data.UserViewModel
import com.example.roomapp.ui.route.Screen

@Composable
fun UserDetailsList(userViewModel: UserViewModel, navController: NavController) {
    val userData: List<User> by userViewModel.readAllData.observeAsState(listOf())

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(userData.size) { index ->
            UserDetailsCard(user = userData[index],navController)
            Spacer(modifier = Modifier.height(16.dp)) // Add space between cards
        }
    }
}

@Composable
fun UserDetailsCard(user: User,navController: NavController) {
    Card(
        modifier = Modifier
            .padding(
                top = 70.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ) // Adjust the top padding as needed
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = Screen.UpdateDetails.route){

                    navController.navigate(route = Screen.UpdateDetails.route)
                }
            }
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {

            Text("ID: ${user.id}")
            Spacer(modifier = Modifier.height(8.dp))

            Text("First Name: ${user.firstName}")
            Spacer(modifier = Modifier.height(8.dp))

            Text("Last Name: ${user.lastName}")
            Spacer(modifier = Modifier.height(8.dp))

            Text("Age: ${user.age}")
            Spacer(modifier = Modifier.height(8.dp))

            Text("Position: ${user.position}")
            Spacer(modifier = Modifier.height(8.dp))

            Text("Rating: ${user.rating}")
        }
    }
}

