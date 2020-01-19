package com.example.cookbookapp.skeleton.adapter

import androidx.annotation.LayoutRes
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel

class SingleTypeRecyclerAdapter<T>(items: ObservableList<T>, @LayoutRes private val layoutId: Int,
    viewModel: BaseViewModel?
) : BaseRecyclerViewAdapter<T>(items, viewModel) {

    override fun getLayoutId(itemType: Int): Int = layoutId
}
