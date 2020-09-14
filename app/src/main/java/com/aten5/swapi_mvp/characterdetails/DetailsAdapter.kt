package com.aten5.swapi_mvp.characterdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aten5.swapi_mvp.R
import com.aten5.swapi_mvp.databinding.CharacterDetailsBinding
import com.aten5.swapi_mvp.model.data.Result

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {
    private val list: MutableList<Result> = mutableListOf()

    fun upDateList(newList: List<Result>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item = item)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(private val binding: CharacterDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Result) {
            binding.result = item
        }


        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val binding: CharacterDetailsBinding =
                    DataBindingUtil.inflate(
                        layoutInflater, R.layout.character_details,
                        parent, false
                    )
                return ViewHolder(binding)
            }
        }

    }


}
