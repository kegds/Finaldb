package com.example.finaldb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.finaldb.entities.UserInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [UserInfo::class],
    version = 1,
    exportSchema = false)

abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao

    private class UserDatabaseCallback(
        private val scope: CoroutineScope
    ):RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var getUserDao = database.getUserDao()

                    getUserDao.deleteUser()

                    var userInfo = UserInfo(
                        userId = 0,
                        firstName = "Caitlyn",
                        middleName = "Sebastian",
                        lastName = "Delos Santos")
                    getUserDao.insertUser(userInfo)
                    userInfo = UserInfo(
                        userId = 1,
                        firstName = "Gemrod",
                        middleName = "Yanzon",
                        lastName = "Triunfo")
                }
            }
        }
    }
    companion object{

        @Volatile
        private var INSTANCE : AppDatabase? =null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}