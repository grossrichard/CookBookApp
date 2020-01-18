package com.example.cookbookapp

import com.example.cookbookapp.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by Richard Gross on 2020-01-14
 */
open class Application : DaggerApplication() {

    private lateinit var instance: Application

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.factory().create(this)

}