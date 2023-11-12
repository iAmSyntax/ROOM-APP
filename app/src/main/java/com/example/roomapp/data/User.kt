package com.example.roomapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity (tableName = "user_data")
data class User (
    @PrimaryKey (autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age:Int,
    val position:String,
    val rating:Int,
):Parcelable
