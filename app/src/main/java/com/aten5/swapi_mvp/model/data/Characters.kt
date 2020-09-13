package com.aten5.swapi_mvp.model.data


import com.squareup.moshi.Json


data class Characters(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "previous")
    val previous: Any,
    @Json(name = "results")
    val results: List<Result>
) : ResultData