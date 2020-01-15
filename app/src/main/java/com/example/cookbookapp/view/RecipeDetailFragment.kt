package com.example.cookbookapp.view

import com.example.cookbookapp.R
import com.example.cookbookapp.databinding.FragmentRecipeDetailBinding
import com.example.cookbookapp.mvvmskeleton.BaseMvvmFragment
import com.example.cookbookapp.viewmodel.RecipeDetailFragmentVM
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
class RecipeDetailFragment :
    BaseMvvmFragment<FragmentRecipeDetailBinding, RecipeDetailFragmentVM>() {

    override val viewModelClass: KClass<RecipeDetailFragmentVM> = RecipeDetailFragmentVM::class
    override val layoutId: Int = R.layout.fragment_recipe_detail
}