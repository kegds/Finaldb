package com.example.finaldb

import androidx.annotation.WorkerThread
import com.example.finaldb.entities.UserInfo
import kotlinx.coroutines.flow.Flow

class UserRepository(private val getUserDao: UserDao) {

    val allUser: Flow<List<UserInfo>> = getUserDao.getAllNames()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(userInfo: UserInfo){
        getUserDao.insertUser(userInfo)
    }
}