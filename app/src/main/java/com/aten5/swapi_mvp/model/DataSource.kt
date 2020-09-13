package com.aten5.swapi_mvp.model

import com.aten5.swapi_mvp.model.data.ResultData

interface DataSource {
    fun getCharactersList()
    fun getCharacterDetail(name: String)

    interface Listener {
        fun onSuccess(data: ResultData)
        fun onFailure(throwable: Throwable)
    }
}