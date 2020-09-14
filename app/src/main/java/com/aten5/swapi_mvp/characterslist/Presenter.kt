package com.aten5.swapi_mvp.characterslist

import com.aten5.swapi_mvp.interfaces.CharactersContract
import com.aten5.swapi_mvp.model.DataSource
import com.aten5.swapi_mvp.model.RetrofitClient
import com.aten5.swapi_mvp.model.data.ResultData

class Presenter(
    private val view: CharactersContract.View
) : CharactersContract.Presenter, DataSource.Listener {

    private val dataSource: DataSource = RetrofitClient(this)

    override fun getData() {
        dataSource.getCharactersList()
        view.showLoading()
    }

    override fun onSuccess(data: ResultData) {
        view.showResult(result = data)
    }

    override fun onFailure(throwable: Throwable) {
        view.showError(throwable.message)
    }
}