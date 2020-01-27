package com.example.cookbookapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cookbookapp.entity.Rating

/**
 * Created by Richard Gross on 2020-01-25
 */

@Dao
interface RatingDao {

    @Query("SELECT * FROM ratings WHERE id == :id")
    fun findRating(id: String): Rating?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRating(rating: Rating)

}