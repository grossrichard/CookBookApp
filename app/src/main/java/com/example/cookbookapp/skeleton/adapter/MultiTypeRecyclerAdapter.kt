package com.example.cookbookapp.skeleton.adapter

import androidx.databinding.ObservableList
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel

class MultiTypeRecyclerAdapter<T : RecyclerItem>(
    items: ObservableList<T>,
    viewModel: BaseViewModel?
) : BaseRecyclerViewAdapter<T>(items, viewModel) {

    override fun getLayoutId(itemType: Int): Int = itemType

    override fun getItemViewType(position: Int): Int = getItem(position).layoutId

}
