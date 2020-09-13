package com.aten5.swapi_mvp.characterslist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.aten5.swapi_mvp.R
import com.aten5.swapi_mvp.databinding.ActivityMainBinding
import com.aten5.swapi_mvp.model.data.Characters
import com.aten5.swapi_mvp.model.data.ResultData

class MainActivity : AppCompatActivity(), CharactersContract.View {
    private lateinit var binding: ActivityMainBinding

    private val viewAdapter = CharactersAdapter()
    private val presenter = Presenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = viewAdapter
        }

        presenter.getData()
    }

    override fun showLoading() {
        binding.loading.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
        binding.errorContainer.visibility = View.GONE
    }

    override fun showResult(result: ResultData) {
        val newList = result as Characters

        // Update RecyclerView Data
        viewAdapter.upDateList(newList = newList.results)

        binding.loading.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
    }

    override fun showError(error: String?) {
        binding.loading.visibility = View.GONE
        binding.errorContainer.visibility = View.VISIBLE
        binding.tvErrorMessage.text = error
    }
}