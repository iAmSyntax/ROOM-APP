package com.example.roomapp.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roomapp.data.User
import com.example.roomapp.ui.composeFunctions.EnterDetailsBar


fun areAllEmptyOrZero(
    firstName: String,
    lastName: String,
    position: String,
    age: Int,
    rating: Int
): Boolean {
    return firstName.isEmpty() && lastName.isEmpty() && position.isEmpty() && age == 0 && rating == 0
}

fun insertDataIntoDb(firstName: String, lastName: String, position: String, age: Int, rating: Int) {
    val user = User(0, firstName, lastName, age, position, rating)

    Log.i("Tag", "Insertion done")
}

@Composable
fun AddDataBtn(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Add Data")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(label: String, text: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberTextField(labelName: String, numVar: Int, onValueChange: (Int) -> Unit) {
    var text by remember { mutableStateOf(numVar.toString()) }
    OutlinedTextField(
        value = text,
        onValueChange = { newValue ->
            // Allow only numeric characters
            if (newValue.isEmpty() || newValue.all { char -> char.isDigit() }) {
                text = newValue
                onValueChange(newValue.toInt())
            }
        },
        label = { Text(labelName) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )
}





@Composable
fun EnterDetailsScreen(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var position by remember { mutableStateOf("") }
    var age by remember { mutableIntStateOf(0) }
    var rating by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        EnterDetailsBar(navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp)
                .verticalScroll(state = rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // The it keyword is used as a default name for the single parameter of the lambda function.
            // In this context, it refers to the new text value that is passed as a parameter to the lambda function
            TextField("First Name", firstName){newValue->firstName=newValue}
            TextField("Last Name", lastName){ newValue -> lastName = newValue }
            NumberTextField(labelName = "Age", numVar = age, onValueChange = { newValue -> age = newValue })
            TextField("Position", position){ newValue -> position = newValue }
            NumberTextField(labelName = "Rating", numVar = rating, onValueChange = { newValue -> rating = newValue })
            AddDataBtn {
                if (firstName.isNotBlank() && lastName.isNotBlank() && position.isNotBlank() && age > 0 && rating > 0) {
                    //insertDataIntoDb(firstName,lastName,position,age,rating)

                    Log.w("Tag", "its not empty")
                } else {
                    Log.w("Tag", "its empty")
                }

            }

        }
    }
}

