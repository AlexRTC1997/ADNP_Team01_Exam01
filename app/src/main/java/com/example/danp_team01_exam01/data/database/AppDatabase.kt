package com.example.danp_team01_exam01.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.danp_team01_exam01.data.ReportDao
import com.example.danp_team01_exam01.data.dao.UserDao
import com.example.danp_team01_exam01.data.dao.UserWithReportsDao
import com.example.danp_team01_exam01.model.Report
import com.example.danp_team01_exam01.model.User

@Database(entities = [(User::class), (Report::class)], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun reportDao(): ReportDao
    abstract fun userWithReportsDao(): UserWithReportsDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}