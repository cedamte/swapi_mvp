package com.aten5.swapi_mvp.model

import com.aten5.swapi_mvp.model.data.Characters
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RetrofitClient @Inject constructor(private val service: SWAPIService) : DataSource {

    override fun getCharactersList(): Single<Characters> {
        return service.getCharactersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getCharacterDetail(name: String): Single<Characters> {
        return service.getCharacterDetail(name = name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}

