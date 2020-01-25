package com.example.cookbookapp.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.example.cookbookapp.entity.Recipe
import com.example.cookbookapp.model.RecipeDataManager
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel
import javax.inject.Inject

/**
 * Created by Richard Gross on 2020-01-13
 */
class AddRecipeVM @Inject constructor(private var dataManager: RecipeDataManager) :
    BaseViewModel() {

    val name: MutableLiveData<String> = MutableLiveData()
    val description: MutableLiveData<String> = MutableLiveData()
    val duration: MutableLiveData<String> = MutableLiveData()
    val ingredients: ObservableList<String> = ObservableArrayList()
    val info: MutableLiveData<String> = MutableLiveData()
    val newIngredient: MutableLiveData<String> = MutableLiveData()

    override fun loadData() {

    }

    fun addRecipe() {
        dataManager.addRecipe(Recipe().apply {
            name = this@AddRecipeVM.name.value
            description = this@AddRecipeVM.description.value
            duration = this@AddRecipeVM.duration.value?.toInt()
            ingredients = this@AddRecipeVM.ingredients
        })
    }

    fun onIngredientAdded() {
        if (!newIngredient.value.isNullOrBlank() || !ingredients.any { it == newIngredient.value }) {
            ingredients.add(newIngredient.value)
            newIngredient.value = null
        }
    }
}