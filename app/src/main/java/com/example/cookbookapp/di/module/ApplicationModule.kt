package com.example.cookbookapp.di.module

import com.example.cookbookapp.Application
import dagger.Module

/**
 * Created by Richard Gross on 2020-01-14
 */
@Module
class ApplicationModule(val application: Application) {

//    @Provides
//    fun provideApp(): Application = application

//    @Provides
//    @ApplicationContext
//    fun provideApplicationContext(): Context = application.applicationContext

//    @Provides
//    fun provideResources(@ApplicationContext context: Context): Resources {
//        return context.resources
//    }
}

