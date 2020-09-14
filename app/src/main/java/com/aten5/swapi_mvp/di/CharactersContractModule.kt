package com.aten5.swapi_mvp.di

import com.aten5.swapi_mvp.characterslist.Presenter
import com.aten5.swapi_mvp.model.DataSource
import dagger.Module
import dagger.Provides

@Module
class CharactersContractModule {

    @Provides
    fun providePresenter(dataSource: DataSource): Presenter {
        return Presenter(dataSource)
    }
}