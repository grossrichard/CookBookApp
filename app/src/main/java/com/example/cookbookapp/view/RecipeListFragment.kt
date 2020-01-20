package com.example.cookbookapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.cookbookapp.BR
import com.example.cookbookapp.R
import com.example.cookbookapp.databinding.FragmentRecipeListBinding
import com.example.cookbookapp.skeleton.adapter.decoration.DividerItemDecoration
import com.example.cookbookapp.skeleton.mvvm.BaseMvvmFragment
import com.example.cookbookapp.skeleton.mvvm.event.NavigateEvent
import com.example.cookbookapp.skeleton.mvvm.event.SomeEvent
import com.example.cookbookapp.viewmodel.RecipeListVM
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
class RecipeListFragment : BaseMvvmFragment<FragmentRecipeListBinding, RecipeListVM>() {

    override val viewModelClass: KClass<RecipeListVM> = RecipeListVM::class
    override val layoutId: Int = R.layout.fragment_recipe_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context!!,
                R.drawable.divider_pink_light
            )
        )

        subscribe(NavigateEvent::class, Observer { onNavigateEvent(it) })
        subscribe(SomeEvent::class, Observer { onSomeEvent(it) })
    }

    private fun onNavigateEvent(evt: NavigateEvent) {
        Navigation.findNavController(view!!).navigate(evt.fragmentId, evt.bundle)
    }

    private fun onSomeEvent(evt: SomeEvent) {
        Log.d("TAG", "onSomeEventClicked!!!!")
    }


}