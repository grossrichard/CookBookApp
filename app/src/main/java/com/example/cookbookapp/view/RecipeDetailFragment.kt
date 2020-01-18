package com.example.cookbookapp.view

import com.example.cookbookapp.R
import com.example.cookbookapp.databinding.FragmentRecipeDetailBinding
import com.example.cookbookapp.skeleton.mvvm.BaseMvvmFragment
import com.example.cookbookapp.viewmodel.RecipeDetailVM
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
class RecipeDetailFragment : BaseMvvmFragment<FragmentRecipeDetailBinding, RecipeDetailVM>() {

    override val viewModelClass: KClass<RecipeDetailVM> = RecipeDetailVM::class
    override val layoutId: Int = R.layout.fragment_recipe_detail
}