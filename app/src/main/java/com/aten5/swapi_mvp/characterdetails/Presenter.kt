package com.aten5.swapi_mvp.characterdetails

import com.aten5.swapi_mvp.model.DataSource
import javax.inject.Inject

class Presenter @Inject constructor(private val dataSource: DataSource) :
    DetailsContract.Presenter {

    private lateinit var mView: DetailsContract.View

    override fun getData(name: String) {
        mView.showLoading()
        dataSource.getCharacterDetail(name = name)
            .subscribe({ data ->
                mView.showResult(result = data)
            }, { error ->
                mView.showError(error = error.message)
            })
    }

    override fun setView(view: DetailsContract.View) {
        mView = view
    }

}