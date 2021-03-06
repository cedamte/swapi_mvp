package com.aten5.swapi_mvp.characterslist

import com.aten5.swapi_mvp.model.data.ResultData

interface CharactersContract {
    interface Presenter {
        fun getData()
        fun setView(view: View)
    }

    interface View {
        fun showLoading()

        fun showResult(result: ResultData)

        fun showError(error: String?)
    }
}