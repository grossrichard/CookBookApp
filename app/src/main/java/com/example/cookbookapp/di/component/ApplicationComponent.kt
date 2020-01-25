/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.cookbookapp.di.component

import android.content.Context
import com.example.cookbookapp.Application
import com.example.cookbookapp.db.AppDatabase
import com.example.cookbookapp.di.ViewModelBuilder
import com.example.cookbookapp.di.module.ApiModule
import com.example.cookbookapp.di.module.ApplicationModule
import com.example.cookbookapp.di.module.DatabaseModule
import com.example.cookbookapp.di.module.FragmentModule
import com.example.cookbookapp.di.qualifier.ApplicationContext
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        FragmentModule::class,
        ViewModelBuilder::class,
        ApiModule::class,
        DatabaseModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<Application> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}