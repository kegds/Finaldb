package com.example.finaldb.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["userId", "rbdId"])
data class DataAndResult (
    val userId: Int,
    val rbdId: Int

)