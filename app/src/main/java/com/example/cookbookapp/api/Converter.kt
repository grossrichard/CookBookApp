package com.example.cookbookapp.api

import com.example.cookbookapp.api.dto.RatingDto
import com.example.cookbookapp.api.dto.RecipeDto
import com.example.cookbookapp.entity.Rating
import com.example.cookbookapp.entity.Recipe

/**
 * Created by Richard Gross on 2020-01-19
 */

object Converter {

    fun convert(recipesDtoList: List<RecipeDto>): List<Recipe> = recipesDtoList.map { convert(it) }

    fun convert(recipeDto: RecipeDto): Recipe =
        Recipe(
            id = recipeDto.id ?: "",
            name = recipeDto.name,
            description = recipeDto.description,
            duration = recipeDto.duration,
            info = recipeDto.info,
            ingredients = recipeDto.ingredients,
            score = recipeDto.score
        )

    fun convert(recipe: Recipe): RecipeDto =
        RecipeDto(
            name = recipe.name,
            description = recipe.description,
            duration = recipe.duration,
            info = recipe.info,
            ingredients = recipe.ingredients,
            score = recipe.score,
            id = if (recipe.id.isBlank()) null else recipe.id
        )


    fun convert(ratingDto: RatingDto): Rating =
        Rating(
            id = ratingDto.id ?: "",
            recipe = ratingDto.recipe,
            score = ratingDto.score
        )
}