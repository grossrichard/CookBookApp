package model

import com.example.cookbookapp.api.Convertor
import com.example.cookbookapp.api.RecipeApiService
import com.example.cookbookapp.entity.Rating
import com.example.cookbookapp.entity.Recipe
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Richard Gross on 2020-01-18
 */

class RecipeDataManager @Inject constructor(private val service: RecipeApiService) {

    fun loadRecipes(): Single<List<Recipe>> =
        service.service.loadRecipes(10, 1).map { Convertor.convert(it) }

    fun addRecipe(recipe: Recipe): Single<Recipe> =
        service.service.addRecipe(Convertor.convert(recipe)).map { Convertor.convert(it) }

    fun loadRecipeDetail(id: String): Single<Recipe> =
        service.service.loadRecipeDetail(id).map { Convertor.convert(it) }

    fun updateRecipe(id: String, recipe: Recipe): Single<Recipe> =
        service.service.updateRecipe(id, Convertor.convert(recipe)).map { Convertor.convert(it) }

    //todo implement response?
    fun deleteRecipe(id: String) = service.service.deleteRecipe(id)

    fun addRating(id: String, score: Int): Single<Rating> =
        service.service.addRating(id, score).map { Convertor.convert(it) }
}