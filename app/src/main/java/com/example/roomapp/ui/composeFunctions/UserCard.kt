package com.example.roomapp.ui.composeFunctions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserDetailsCard() {
    Card(
        modifier = Modifier
            .padding(
                top = 70.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ) // Adjust the top padding as needed
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text("ID: 2")
            Spacer(modifier = Modifier.height(8.dp))

            Text("First Name: Jamal")
            Spacer(modifier = Modifier.height(8.dp))

            Text("Last Name: Shameem")
            Spacer(modifier = Modifier.height(8.dp))

            Text("Age: 24")
            Spacer(modifier = Modifier.height(8.dp))

            Text("Position: Striker")
            Spacer(modifier = Modifier.height(8.dp))

            Text("Rating: 23")
        }
    }
}

