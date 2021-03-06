package com.example.cookbookapp.view

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.example.cookbookapp.R
import com.example.cookbookapp.databinding.FragmentRecipeListBinding
import com.example.cookbookapp.skeleton.adapter.decoration.DividerItemDecoration
import com.example.cookbookapp.skeleton.mvvm.BaseMvvmFragment
import com.example.cookbookapp.util.UiUtils
import com.example.cookbookapp.viewmodel.RecipeListVM
import kotlinx.android.synthetic.main.fragment_recipe_list.*
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
class RecipeListFragment : BaseMvvmFragment<FragmentRecipeListBinding, RecipeListVM>() {

    override val viewModelClass: KClass<RecipeListVM> = RecipeListVM::class
    override val layoutId: Int = R.layout.fragment_recipe_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadRecipes()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_add_recipe -> {
                    Navigation.findNavController(view)
                        .navigate(RecipeListFragmentDirections.navigateRecipeListToAddRecipe())
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }

        rv_recipes.addItemDecoration(
            androidx.recyclerview.widget.DividerItemDecoration(
                context,
                androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
            ).apply { setDrawable(UiUtils.getDrawable(R.drawable.divider_pink_light)!!) })
    }
}