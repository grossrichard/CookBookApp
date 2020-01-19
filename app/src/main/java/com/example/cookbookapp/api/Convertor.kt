package com.example.cookbookapp.api

import com.example.cookbookapp.api.dto.RatingDto
import com.example.cookbookapp.api.dto.RecipeDto
import com.example.cookbookapp.entity.Rating
import com.example.cookbookapp.entity.Recipe

/**
 * Created by Richard Gross on 2020-01-19
 */

object Convertor {


    fun convert(recipesDtoList: List<RecipeDto>): List<Recipe> {
        return listOf()
    }

    fun convert(recipeDto: RecipeDto): Recipe {
        return Recipe()
    }

    fun convert(recipe: Recipe): RecipeDto {
        return RecipeDto()
    }

    fun convert(ratingDto: RatingDto): Rating {
        return Rating()
    }
}