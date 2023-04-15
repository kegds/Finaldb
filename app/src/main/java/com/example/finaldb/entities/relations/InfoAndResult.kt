package com.example.finaldb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.finaldb.entities.UserInfo
import com.example.finaldb.entities.UserResult

class InfoAndResult (
    @Embedded val userInfo: UserInfo,
    @Relation(
        parentColumn = "userId",
        entityColumn = "uresultId"
    )
    val userResult: UserResult
)