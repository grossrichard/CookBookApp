package com.example.cookbookapp.skeleton.adapter

import androidx.annotation.LayoutRes
import androidx.databinding.ObservableArrayList
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel

class SingleTypeRecyclerAdapter<T>(
    items: ObservableArrayList<T>,
    @LayoutRes private val layoutId: Int,
    viewModel: BaseViewModel
) : BaseRecyclerViewAdapter<T>(items, viewModel) {

    override fun getLayoutId(itemType: Int): Int = layoutId
}
