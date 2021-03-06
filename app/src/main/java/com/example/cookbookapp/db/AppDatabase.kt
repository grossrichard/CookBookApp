package com.example.cookbookapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cookbookapp.entity.Rating
import com.example.cookbookapp.entity.Recipe

/**
 * Created by Richard Gross on 2020-01-25
 */

@Database(entities = [Recipe::class, Rating::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
    abstract fun ratingDao(): RatingDao
    abstract fun recipeDetailDao(): RecipeDetailDao
}