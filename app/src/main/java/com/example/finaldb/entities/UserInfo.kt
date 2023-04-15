package com.example.finaldb.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finaldb.R

@Entity
data class UserInfo (
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,

    @ColumnInfo (name = "First Name")
    var firstName: String,

    @ColumnInfo (name = "Last Name")
    var lastName: String,

    @ColumnInfo (name = "Middle Name")
    var middleName: String,
    var imageId: Int = R.drawable.profile
)