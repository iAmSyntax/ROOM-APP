package com.example.roomapp.ui.route

sealed class Screen(val route:String) {
    object Home:Screen("home_screen")
    object EnterDetails:Screen("details_screen")
    object UpdateDetails:Screen("update_screen")

}