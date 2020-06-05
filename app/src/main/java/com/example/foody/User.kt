package com.example.foody

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class User {
    @PrimaryKey
    var id:String = ""

    @ColumnInfo(name="name")
    var name:String=""

    @ColumnInfo(name="password")
    var pass:String=""

}