package com.example.cookbookapp.di.module

import androidx.lifecycle.ViewModel
import com.example.cookbookapp.di.ViewModelBuilder
import com.example.cookbookapp.di.ViewModelKey
import com.example.cookbookapp.view.AddRecipeFragment
import com.example.cookbookapp.view.RecipeDetailFragment
import com.example.cookbookapp.view.RecipeListFragment
import com.example.cookbookapp.viewmodel.AddRecipeVM
import com.example.cookbookapp.viewmodel.RecipeDetailVM
import com.example.cookbookapp.viewmodel.RecipeListVM
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Richard Gross on 2020-01-17
 */

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun recipeListFragment(): RecipeListFragment

    @Binds
    @IntoMap
    @ViewModelKey(RecipeListVM::class)
    abstract fun recipeListVM(vm: RecipeListVM): ViewModel

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun recipeDetailFragment(): RecipeDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(RecipeDetailVM::class)
    abstract fun recipeDetailVM(vm: RecipeDetailVM): ViewModel

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun addRecipeFragment(): AddRecipeFragment

    @Binds
    @IntoMap
    @ViewModelKey(AddRecipeVM::class)
    abstract fun addRecipeVM(vm: AddRecipeVM): ViewModel
}