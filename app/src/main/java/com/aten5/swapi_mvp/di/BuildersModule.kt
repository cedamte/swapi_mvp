package com.aten5.swapi_mvp.di

import com.aten5.swapi_mvp.characterslist.Presenter
import com.aten5.swapi_mvp.model.DataSource
import com.aten5.swapi_mvp.model.RetrofitClient
import dagger.Binds
import dagger.Module

@Module
abstract class BuildersModule {
    @Binds
    abstract fun bindGetDataSource(retrofitClient: RetrofitClient): DataSource
}