package com.aten5.swapi_mvp.model

import com.aten5.swapi_mvp.BuildConfig
import com.aten5.swapi_mvp.model.data.Characters
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SWAPIService {
    @GET(BuildConfig.END_POINT)
    fun getCharactersList(): Single<Characters>

    @GET(BuildConfig.END_POINT)
    fun getCharacterDetail(@Query("id") name: String): Single<Characters>
}