package com.example.cookbookapp.mvvmskeleton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.cookbookapp.BR
import com.example.cookbookapp.mvvmskeleton.BaseViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

/**
 * Created by Richard Gross on 2020-01-13
 */
abstract class BaseMvvmFragment<B : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected abstract val viewModelClass: KClass<VM>

    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass.java)
        lifecycle.addObserver(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        initBinding(binding)
        return binding.root
    }

    protected open fun initBinding(binding: B) {
        binding.setVariable(BR.vm, viewModel)
    }
}