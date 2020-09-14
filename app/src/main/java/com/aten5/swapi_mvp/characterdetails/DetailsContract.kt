package com.aten5.swapi_mvp.characterdetails

import com.aten5.swapi_mvp.model.data.ResultData

interface DetailsContract {
    interface Presenter {
        fun getData(name: String)
        fun setView(view: View)
    }

    interface View {
        fun showLoading()

        fun showResult(result: ResultData)

        fun showError(error: String?)
    }
}