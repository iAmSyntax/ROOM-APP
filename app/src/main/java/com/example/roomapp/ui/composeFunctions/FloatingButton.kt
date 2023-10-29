package com.example.roomapp.ui.composeFunctions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomFloatingActionButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier
                .size(90.dp)
                .padding(15.dp)
                .align(Alignment.BottomEnd), // Position in the bottom right corner
            containerColor = Color.Cyan,
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Button",
                tint = Color.Blue
            )
        }
    }
}
