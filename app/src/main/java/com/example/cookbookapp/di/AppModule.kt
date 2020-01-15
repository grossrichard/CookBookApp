package com.example.cookbookapp.di

import dagger.Module

/**
 * Created by Richard Gross on 2020-01-14
 */
@Module(includes = [AppModuleBinds::class])
object AppModule {


}

@Module
abstract class AppModuleBinds {

}
