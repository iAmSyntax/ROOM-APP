package com.example.roomapp.ui.route

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomapp.data.User

class SharedViewModel : ViewModel() {

    var userShared by mutableStateOf<User?>(null)
        private set

    fun addUserShared(newUserShared:User){
        userShared = newUserShared
    }


}