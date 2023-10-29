package com.example.roomapp.data

import androidx.lifecycle.LiveData

//Repository class abstracts access to multiple data source
class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllUser();

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

}