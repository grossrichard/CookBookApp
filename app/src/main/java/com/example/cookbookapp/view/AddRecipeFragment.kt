package com.example.cookbookapp.view

import com.example.cookbookapp.R
import com.example.cookbookapp.databinding.FragmentAddRecipeBinding
import com.example.cookbookapp.skeleton.mvvm.BaseMvvmFragment
import com.example.cookbookapp.viewmodel.AddRecipeVM
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
class AddRecipeFragment : BaseMvvmFragment<FragmentAddRecipeBinding, AddRecipeVM>() {

    override val viewModelClass: KClass<AddRecipeVM> = AddRecipeVM::class
    override val layoutId: Int = R.layout.fragment_add_recipe
}