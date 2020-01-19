package com.example.cookbookapp.model

import com.example.cookbookapp.api.Converter
import com.example.cookbookapp.api.RecipeApiService
import com.example.cookbookapp.entity.Rating
import com.example.cookbookapp.entity.Recipe
import com.example.cookbookapp.skeleton.mvvm.BaseDataManager
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Richard Gross on 2020-01-18
 */

@Singleton
class RecipeDataManager @Inject constructor(private val service: RecipeApiService) :
    BaseDataManager() {

    fun loadRecipes(): Single<List<Recipe>> =
        service.service.loadRecipes(10, 1).map { Converter.convert(it) }

    fun addRecipe(recipe: Recipe): Single<Recipe> =
        service.service.addRecipe(Converter.convert(recipe)).map { Converter.convert(it) }

    fun loadRecipeDetail(id: String): Single<Recipe> =
        service.service.loadRecipeDetail(id).map { Converter.convert(it) }

    fun updateRecipe(id: String, recipe: Recipe): Single<Recipe> =
        service.service.updateRecipe(id, Converter.convert(recipe)).map { Converter.convert(it) }

    //todo implement response?
    fun deleteRecipe(id: String) = service.service.deleteRecipe(id)

    fun addRating(id: String, score: Int): Single<Rating> =
        service.service.addRating(id, score).map { Converter.convert(it) }
}