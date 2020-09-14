package com.aten5.swapi_mvp.characterdetails

import com.aten5.swapi_mvp.model.data.ResultData

interface DetailsContract {
    interface Presenter {
        fun getData(name: String)
    }

    interface View {
        fun showLoading()

        fun showResult(result: ResultData)

        fun showError(error: String?)
    }
}