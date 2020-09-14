package com.aten5.swapi_mvp.di

import com.aten5.swapi_mvp.app.MyApplication
import com.aten5.swapi_mvp.characterdetails.DetailsActivity
import com.aten5.swapi_mvp.characterslist.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [
        ApiModule::class,
        BuildersModule::class,
        CharactersContractModule::class
    ]
)
@Singleton
interface AppComponent {
    fun inject(application: MyApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(detailsActivity: DetailsActivity)
}