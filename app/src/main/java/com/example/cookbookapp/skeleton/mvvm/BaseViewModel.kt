package com.example.cookbookapp.skeleton.mvvm

import androidx.lifecycle.*
import com.example.cookbookapp.skeleton.mvvm.event.LiveEvent
import com.example.cookbookapp.skeleton.mvvm.event.LiveEventMap
import io.reactivex.disposables.CompositeDisposable
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {

    private val liveEventMap: LiveEventMap = LiveEventMap()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
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

    open fun <T : LiveEvent> subscribe(
        lifecycleOwner: LifecycleOwner,
        eventClass: KClass<T>,
        eventObserver: Observer<T>
    ) = liveEventMap.subscribe(lifecycleOwner, eventClass, eventObserver)

}