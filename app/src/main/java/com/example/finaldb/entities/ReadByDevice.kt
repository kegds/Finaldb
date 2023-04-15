package com.example.finaldb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class ReadByDevice (
    @PrimaryKey (autoGenerate = false)
    val rdbId: Int,
    val badPostureCount: Int,
    val calibratedRoll: Float,
    val calibratedPitch: Float,
    val calibratedFlexSensor: Float,
    val recordedTime: LocalDateTime,
    val mode: Boolean
        )