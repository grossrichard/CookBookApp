package com.example.cookbookapp.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
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

    var recipesList = ObservableArrayList<Recipe>()
    var name = ObservableField<String>()

    override fun loadData() {
        super.loadData()
        subscribeSingle(dataManager.loadRecipes(), Consumer(this::onRecipesLoaded))
    }

    private fun onRecipesLoaded(list: List<Recipe>) {
        loading.value = false
        recipesList.clear()
        recipesList.addAll(list)

        name.set("Hovno")
    }

    fun onItemClicked(recipe: Recipe) {
        publish(NavigateEvent(RecipeListFragmentDirections.navigateRecipeListToRecipeDetail(recipe)))
    }

    fun onAddRecipeClicked() {
        publish(SomeEvent())
    }

    companion object {
        const val ARG_RECIPE_ID = "ARG_RECIPE_ID"
    }
}

