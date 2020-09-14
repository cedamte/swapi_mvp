package com.aten5.swapi_mvp.characterslist

import com.aten5.swapi_mvp.model.DataSource
import com.aten5.swapi_mvp.model.RetrofitClient
import com.aten5.swapi_mvp.model.data.ResultData

class Presenter : CharactersContract.Presenter {
    private val dataSource: DataSource = RetrofitClient()

    lateinit var mView: CharactersContract.View

    override fun getData() {
        mView.showLoading()
        dataSource.getCharactersList()
            .subscribe({ data ->
                mView.showResult(result = data)
            }, { error ->
                mView.showError(error = error.message)
            })
    }


    override fun setView(view: CharactersContract.View) {
        mView = view
    }

}