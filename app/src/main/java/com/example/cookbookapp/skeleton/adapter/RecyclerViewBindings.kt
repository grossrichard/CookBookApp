package com.example.cookbookapp.skeleton.adapter

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookbookapp.skeleton.mvvm.BaseViewModel

/**
 * Created by Richard Gross on 2020-01-15
 */

@BindingAdapter(
    "viewModel",
    "items",
    "itemLayoutId",
    "orientation",
    "lifecycleOwner",
    "divider",
    requireAll = false
)
@Suppress("unchecked_cast")
fun <T> bindViewModel(
    view: RecyclerView,
    vm: BaseViewModel,
    items: ObservableArrayList<T>,
    itemLayoutId: Int?,
    orientation: Int?,
    lifecycleOwner: LifecycleOwner?,
    dividerItemDecoration: RecyclerView.ItemDecoration?
) {

    if (view.layoutManager == null) {
        view.layoutManager = LinearLayoutManager(
            view.context, orientation
                ?: RecyclerView.VERTICAL, false
        )
    }

    dividerItemDecoration?.let { view.addItemDecoration(it) }

    view.adapter?.let {
        (view.adapter as BaseRecyclerViewAdapter<T>).items = items
    } ?: run {
        itemLayoutId?.let {
            view.adapter = SingleTypeRecyclerAdapter(items,itemLayoutId,vm)
        } ?: run {
            view.adapter = MultiTypeRecyclerAdapter(items as ObservableArrayList<RecyclerItem>, vm)
        }
    }

    (view.adapter as BaseRecyclerViewAdapter<T>).lifecycleOwner = lifecycleOwner

}
