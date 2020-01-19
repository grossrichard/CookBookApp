package com.example.cookbookapp.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.example.cookbookapp.entity.Recipe
import com.example.cookbookapp.model.RecipeDataManager
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel
import com.example.cookbookapp.skeleton.mvvm.event.NavigateEvent
import com.example.cookbookapp.view.RecipeListFragmentDirections
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by Richard Gross on 2020-01-13
 */
class RecipeListVM @Inject constructor(private var dataManager: RecipeDataManager) :
    BaseViewModel() {

    var recipesList: ObservableList<Recipe> = ObservableArrayList<Recipe>()

    override fun loadData() {
        super.loadData()
        subscribeSingle(dataManager.loadRecipes(), Consumer(this::onRecipesLoaded))
    }

    private fun onRecipesLoaded(list: List<Recipe>) {
        recipesList.clear()
        recipesList.addAll(list)
    }

    fun onItemClicked(recipe: Recipe) {
        val direction = RecipeListFragmentDirections.navigateRecipeListToRecipeDetail(recipe.id)
        publish(NavigateEvent(direction))
    }

    fun addRecipe() {
        val direction = RecipeListFragmentDirections.navigateRecipeListToAddRecipe()
        publish(NavigateEvent(direction))
    }
}

