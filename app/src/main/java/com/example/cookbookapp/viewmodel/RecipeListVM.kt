package com.example.cookbookapp.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.example.cookbookapp.entity.Recipe
import com.example.cookbookapp.model.RecipeDataManager
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel
import com.example.cookbookapp.skeleton.mvvm.event.NavigateEvent
import com.example.cookbookapp.skeleton.mvvm.event.SomeEvent
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
        loading.value = false
        recipesList.clear()
        recipesList.addAll(list)
    }

    fun onItemClicked(recipe: Recipe) {
        publish(NavigateEvent(RecipeListFragmentDirections.navigateRecipeListToRecipeDetail(recipe.id)))
    }

    fun onAddRecipeClicked() {
        publish(SomeEvent())
    }

    companion object {
        const val ARG_RECIPE_ID = "ARG_RECIPE_ID"
    }
}

