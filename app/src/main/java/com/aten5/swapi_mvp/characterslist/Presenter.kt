package com.aten5.swapi_mvp.characterslist

import com.aten5.swapi_mvp.model.DataSource
import javax.inject.Inject

class Presenter @Inject constructor(private val dataSource: DataSource) :
    CharactersContract.Presenter {

    private lateinit var mView: CharactersContract.View

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