package com.example.cookbookapp.view

import com.example.cookbookapp.R
import com.example.cookbookapp.databinding.FragmentAddRecipeBinding
import com.example.cookbookapp.mvvmskeleton.BaseMvvmFragment
import com.example.cookbookapp.viewmodel.AddRecipeFragmentVM
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
class AddRecipeFragment : BaseMvvmFragment<FragmentAddRecipeBinding, AddRecipeFragmentVM>() {

    override val viewModelClass: KClass<AddRecipeFragmentVM> = AddRecipeFragmentVM::class
    override val layoutId: Int = R.layout.fragment_add_recipe

}