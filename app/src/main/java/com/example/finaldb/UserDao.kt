package com.example.finaldb

import androidx.room.*
import com.example.finaldb.entities.UserInfo
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(userInfo: UserInfo)

    @Query("DELETE FROM userinfo")
    suspend fun deleteUser()

    @Query("SELECT * FROM userinfo ORDER BY userId ASC")
    fun getAllNames(): Flow<List<UserInfo>>



}