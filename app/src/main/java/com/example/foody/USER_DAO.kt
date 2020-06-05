package com.example.foody

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface USER_DAO {

    @Insert
    fun register(user: User)

    @Query("select * from User")
    fun read() : List<User>
}