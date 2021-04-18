package com.example.mobillabor.data

import android.content.Context
import androidx.room.Room
import com.example.mobillabor.data.dao.MeterageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
class DataModule {
    companion object {
        private const val DB_NAME = "meterages.db"
    }

    @Provides
    fun provideMeterageDao(db: AppDatabase): MeterageDao = db.meterageDao()

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}