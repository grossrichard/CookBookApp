package com.example.cookbookapp.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cookbookapp.Application
import com.example.cookbookapp.db.AppDatabase
import com.example.cookbookapp.db.RatingDao
import com.example.cookbookapp.db.RecipeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Richard Gross on 2020-01-25
 */

@Module
object DatabaseModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "recipe.db"
        ).allowMainThreadQueries()
            .build()
    }
}