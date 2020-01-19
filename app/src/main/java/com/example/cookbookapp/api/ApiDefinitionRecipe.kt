package com.example.cookbookapp.api

import com.example.cookbookapp.api.dto.RatingDto
import com.example.cookbookapp.api.dto.RecipeDto
import io.reactivex.Single
import retrofit2.http.*

/**
 * Created by Richard Gross on 2020-01-18
 */
interface ApiDefinitionRecipe {

    @GET("recipes")
    fun loadRecipes(@Query("limit") limit: Int, @Query("offset") offset: Int): Single<List<RecipeDto>>

    @POST("recipes")
    fun addRecipe(@Body recipe: RecipeDto): Single<RecipeDto>

    @PUT("recipes/{recipeId}")
    fun updateRecipe(@Path("recipeId") id: String, recipe: RecipeDto): Single<RecipeDto>

    @DELETE("recipes/{recipeId}")
    fun deleteRecipe(@Path("recipeId") id: String)

    @GET("recipes/{recipeId}")
    fun loadRecipeDetail(@Path("recipeId") id: String): Single<RecipeDto>

    @POST("recipes/{recipeId/ratings")
    fun addRating(@Path("recipeId") id: String, @Body score: Int): Single<RatingDto>
}