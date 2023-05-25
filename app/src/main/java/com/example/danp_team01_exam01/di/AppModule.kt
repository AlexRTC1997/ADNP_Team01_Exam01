package com.example.danp_team01_exam01.di

import android.content.Context
import androidx.room.Room
import com.example.danp_team01_exam01.data.ReportDao
import com.example.danp_team01_exam01.data.dao.UserDao
import com.example.danp_team01_exam01.data.dao.UserWithReportsDao
import com.example.danp_team01_exam01.data.database.AppDatabase
import com.example.danp_team01_exam01.data.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideAppDatabase(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
    AppDatabase::class.java,
    "appDatabase").build()

    @Provides
    fun provideUserDao(
        appDb: AppDatabase
    ) = appDb.userDao()

    @Provides
    fun provideReportDao(
        appDb: AppDatabase
    ) = appDb.reportDao()

    @Provides
    fun provideUserWithReportsDao(
        appDb: AppDatabase
    ) = appDb.userWithReportsDao()

    @Provides
    fun provideAppRepository(
        userDao: UserDao,
        reportDao: ReportDao,
        reportsDao: UserWithReportsDao
    ) : AppRepository = AppRepository(userDao, reportDao, reportsDao)
}