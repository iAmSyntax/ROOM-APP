package com.example.roomapp.ui.screens

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roomapp.data.User
import com.example.roomapp.data.UserViewModel
import com.example.roomapp.ui.composeFunctions.EnterDetailsBar


fun checkInput(
    firstNameValue: String,
    lastNameValue: String,
    ageValue: Int,
    positionValue: String,
    ratingValue: Int
): Boolean {
    return firstNameValue.isNotEmpty() &&
            lastNameValue.isNotEmpty() &&
            ageValue > 0 && // Assuming age should be greater than 0
            positionValue.isNotEmpty() &&
            ratingValue >= 0  // Assuming rating should be greater than 0
}
private fun InsertDataToDatabase(
    firstNameValue: String,
    lastNameValue: String,
    ageValue: Int,
    positionValue: String,
    ratingValue: Int
) {
   /* mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
     'this' is not possible here :- The error "this is not defined in this context"
     typically occurs when you are trying to use this within a context where this
     is not available. In Android, this usually refers to the current activity or
     context, but it's important to use it in a context where it's valid.
    */

    val viewModel = UserViewModel(Application())
    if (checkInput(
            firstNameValue,
            lastNameValue,
            ageValue,
            positionValue,
            ratingValue
    )){
        val user = User(0,firstNameValue,lastNameValue,ageValue,positionValue,ratingValue)
        Toast.makeText(viewModel.getApplication(),"User Added", Toast.LENGTH_SHORT).show()

    }else{
        Toast.makeText(viewModel.getApplication(),"Add Missing Parameters", Toast.LENGTH_SHORT).show()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithLabel(
    labelName: String,
    text: String,
    onTextChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        TextField(
            value = text,
            onValueChange = { newText ->
                onTextChanged(newText)
            },
            label = { Text(labelName) })
    }
}


@Composable
fun ButtonAdd(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Add Data")
    }
}

@Composable
fun EnterDetailsScreen(navController: NavController) {
    var firstNameText by remember { mutableStateOf("Enter your First Name") }
    var lastNameText by remember { mutableStateOf("Enter your Last Name") }
    var ageText by remember { mutableStateOf("Enter your Age") }
    var positionText by remember { mutableStateOf("Enter your Position") }
    var ratingText by remember { mutableStateOf("Enter your Rating") }

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
            // In this context, it refers to the new text value that is passed as a parameter to the lambda function.
            TextFieldWithLabel("First Name", firstNameText) {
                firstNameText = it
            }
            TextFieldWithLabel("Last Name", lastNameText) {
                lastNameText = it
            }
            TextFieldWithLabel("Age", ageText) {
                ageText = it
            }
            TextFieldWithLabel("Position", positionText) {
                positionText = it
            }
            TextFieldWithLabel("Rating", ratingText) {
                ratingText = it
            }



            ButtonAdd {
                    InsertDataToDatabase(
                        firstNameValue = firstNameText,
                        lastNameValue = lastNameText,
                        ageValue = ageText.toInt(),
                        positionValue = positionText,
                        ratingValue = ratingText.toInt()
                    )



            }
        }
    }
}




