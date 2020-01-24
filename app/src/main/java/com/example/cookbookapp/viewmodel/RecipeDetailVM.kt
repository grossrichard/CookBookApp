package com.example.cookbookapp.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
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

    var recipeId: String? = null
    val name: MutableLiveData<String> = MutableLiveData()
    var description: MutableLiveData<String> = MutableLiveData()
    var duration: MutableLiveData<Int> = MutableLiveData()
    var ingredients: ObservableList<String> = ObservableArrayList()
    var info: MutableLiveData<String> = MutableLiveData()
    var score: MutableLiveData<Float> = MutableLiveData()

    override fun loadData() {
        super.loadData()

        recipeId?.let {
            subscribeSingle(
                dataManager.loadRecipeDetail(it),
                Consumer(this::onRecipeDetailLoaded)
            )
        }
    }

    private fun onRecipeDetailLoaded(recipe: Recipe) {
        loading.value = false
        ingredients.isNullOrEmpty()
        name.value = recipe.name
        description.value = recipe.description
        duration.value = recipe.duration
        ingredients.apply {
            clear()
            recipe.ingredients?.let { it1 -> addAll(it1) }
        }
        info.value = recipe.info
        score.value = recipe.score
    }
}