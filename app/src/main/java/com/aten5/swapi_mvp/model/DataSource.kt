package com.aten5.swapi_mvp.model

import com.aten5.swapi_mvp.model.data.Characters
import io.reactivex.rxjava3.core.Single

interface DataSource {
    fun getCharactersList(): Single<Characters>
    fun getCharacterDetail(name: String): Single<Characters>
}