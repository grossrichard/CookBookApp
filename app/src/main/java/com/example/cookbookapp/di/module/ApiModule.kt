package com.example.cookbookapp.di.module

import android.util.Log
import com.example.cookbookapp.Application
import com.example.cookbookapp.api.ApiConfig
import com.example.cookbookapp.api.RecipeApiDefinition
import com.example.cookbookapp.api.RecipeApiDefinitionMock
import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Richard Gross on 2020-01-19
 */

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideRecipeApiDefinition(): RecipeApiDefinition =
        RecipeApiDefinitionMock()

//        Retrofit.Builder()
//            .baseUrl(ApiConfig.BASE_ENDPOINT_URL)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//            .client(
//                OkHttpClient()
//                    .newBuilder()
//                    .addInterceptor(ChuckInterceptor(Application.instance))
//                    .addInterceptor {
//                        val req = it.request()
//                        it.proceed(req.newBuilder().build())
//                    }
//                    .build()
//            )
//            .addConverterFactory(GsonConverterFactory.create(Gson()))
//            .build()
//            .create(RecipeApiDefinition::class.java)
}