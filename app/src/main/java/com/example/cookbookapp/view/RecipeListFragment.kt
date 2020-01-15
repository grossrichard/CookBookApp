package com.example.cookbookapp.view

import com.example.cookbookapp.R
import com.example.cookbookapp.databinding.FragmentRecipeListBinding
import com.example.cookbookapp.mvvmskeleton.BaseMvvmFragment
import com.example.cookbookapp.viewmodel.RecipeListFragmentVM
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
class RecipeListFragment : BaseMvvmFragment<FragmentRecipeListBinding, RecipeListFragmentVM>() {

    override val viewModelClass: KClass<RecipeListFragmentVM> = RecipeListFragmentVM::class
    override val layoutId: Int = R.layout.fragment_recipe_list


}