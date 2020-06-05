package com.example.foody

import androidx.room.Database
import androidx.room.Insert
import androidx.room.RoomDatabase

@Database(entities = [(User::class)],version = 2)
abstract class AppDB : RoomDatabase() {
    abstract fun userDao() : USER_DAO
}