package com.example.finaldb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class UserResult (
    @PrimaryKey(autoGenerate = false)
    val uresultId: Int,
    val totalBadPostureCount: Int,
    val totalTime: Long = 0,
    val calibratedX: Float,
    val calibratedY: Float,
    val calibratedZ: Float,
    val userId: Int,
    val mode: Boolean
    )