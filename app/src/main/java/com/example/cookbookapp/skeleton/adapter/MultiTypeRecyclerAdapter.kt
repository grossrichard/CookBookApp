package com.example.cookbookapp.skeleton.adapter

import androidx.databinding.ObservableArrayList
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel

class MultiTypeRecyclerAdapter<T : RecyclerItem>(
    items: ObservableArrayList<T>, viewModel: BaseViewModel
) : BaseRecyclerViewAdapter<T>(items, viewModel) {

    override fun getLayoutId(itemType: Int): Int = itemType

    override fun getItemViewType(position: Int): Int = getItem(position).layoutId

}
