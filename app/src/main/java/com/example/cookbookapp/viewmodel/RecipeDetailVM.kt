package com.example.cookbookapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.cookbookapp.entity.Recipe
import com.example.cookbookapp.model.RecipeDataManager
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by Richard Gross on 2020-01-13
 */
class RecipeDetailVM @Inject constructor(private val dataManager: RecipeDataManager) :
    BaseViewModel() {

    var recipeDetail: MutableLiveData<Recipe> = MutableLiveData()

    override fun loadData() {
        super.loadData()

        subscribeSingle(
            dataManager.loadRecipeDetail("5dd3dde59f9c641100f3556f"),
            Consumer(this::onRecipeDetailLoaded)
        )
    }

    private fun onRecipeDetailLoaded(recipe: Recipe) {
        this.recipeDetail.value = recipe
    }
}