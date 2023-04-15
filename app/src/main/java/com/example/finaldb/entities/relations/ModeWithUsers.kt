package com.example.finaldb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.finaldb.entities.Modes
import com.example.finaldb.entities.UserInfo

data class ModeWithUsers (
    @Embedded val modes: Modes,
    @Relation(
        parentColumn = "modeId",
        entityColumn = "userId"
    )
    val userInfo: List<UserInfo>
)