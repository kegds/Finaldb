package com.example.finaldb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.finaldb.entities.Modes
import com.example.finaldb.entities.UserResult

class ModesAndData (
    @Embedded val modes: Modes,
    @Relation(
        parentColumn = "modeId",
        entityColumn = "rdbId"
    )

    val userResult: UserResult
        )