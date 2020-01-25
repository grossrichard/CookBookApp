package com.example.cookbookapp.view

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.example.cookbookapp.R
import com.example.cookbookapp.databinding.FragmentAddRecipeBinding
import com.example.cookbookapp.skeleton.mvvm.BaseMvvmFragment
import com.example.cookbookapp.viewmodel.AddRecipeVM
import kotlinx.android.synthetic.main.fragment_recipe_list.*
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
class AddRecipeFragment : BaseMvvmFragment<FragmentAddRecipeBinding, AddRecipeVM>() {

    override val viewModelClass: KClass<AddRecipeVM> = AddRecipeVM::class
    override val layoutId: Int = R.layout.fragment_add_recipe

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_add_recipe -> {
                   viewModel.addRecipe()
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }
    }
}