package com.example.cookbookapp.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.example.cookbookapp.entity.Recipe
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel
import io.reactivex.functions.Consumer
import model.RecipeDataManager
import javax.inject.Inject

/**
 * Created by Richard Gross on 2020-01-13
 */
class RecipeListVM @Inject constructor() : BaseViewModel() {

    lateinit var dataManager: RecipeDataManager

    var recipesList: ObservableList<Recipe> = ObservableArrayList<Recipe>()
        private set

    fun onItemClicked(recipe: Recipe) {
        // todo implement
    }

    override fun loadData() {
        super.loadData()
        subscribeSingle(
            dataManager.loadRecipes(),
            Consumer(this::onRecipesLoaded),
            Consumer(this::onError)
        )
    }

    private fun onRecipesLoaded(list: List<Recipe>) {
        recipesList.clear()
        recipesList.addAll(list)
    }

}

