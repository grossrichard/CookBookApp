package com.example.cookbookapp.view

import com.example.cookbookapp.R
import com.example.cookbookapp.databinding.FragmentRecipeListBinding
import com.example.cookbookapp.skeleton.mvvm.BaseMvvmFragment
import com.example.cookbookapp.viewmodel.RecipeListVM
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
class RecipeListFragment : BaseMvvmFragment<FragmentRecipeListBinding, RecipeListVM>() {

    override val viewModelClass: KClass<RecipeListVM> = RecipeListVM::class
    override val layoutId: Int = R.layout.fragment_recipe_list


}