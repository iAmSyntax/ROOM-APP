package com.example.roomapp.data

import androidx.room.Dao

@Dao
interface UserDao {

    fun addUser(user:User){

    }
}