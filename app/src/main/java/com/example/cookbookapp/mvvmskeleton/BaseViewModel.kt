package com.example.cookbookapp.mvvmskeleton

import androidx.lifecycle.*

/**
 * Created by Richard Gross on 2020-01-13
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {

    var loading: MutableLiveData<Boolean> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onViewCreated() {
        initData()
        loadData()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() { // override in child classes
    }

    protected open fun initData() { // override in child classes
    }

    protected open fun loadData() { // override in child classes
        loading.value = true
    }

}