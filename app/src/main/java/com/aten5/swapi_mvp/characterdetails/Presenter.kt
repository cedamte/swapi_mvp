package com.aten5.swapi_mvp.characterdetails

import com.aten5.swapi_mvp.model.DataSource
import com.aten5.swapi_mvp.model.RetrofitClient
import com.aten5.swapi_mvp.model.data.ResultData

class Presenter(private val view: DetailsContract.View) : DetailsContract.Presenter,
    DataSource.Listener {

    private val dataSource: DataSource = RetrofitClient(this)

    override fun getData(name: String) {
        dataSource.getCharacterDetail(name = name)
        view.showLoading()
    }


    override fun onSuccess(data: ResultData) {
        view.showResult(result = data)
    }

    override fun onFailure(throwable: Throwable) {
        view.showError(throwable.message)
    }

}