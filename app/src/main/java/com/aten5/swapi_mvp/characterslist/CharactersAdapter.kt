package com.aten5.swapi_mvp.characterslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aten5.swapi_mvp.R
import com.aten5.swapi_mvp.databinding.ListItemCharacterBinding
import com.aten5.swapi_mvp.model.data.Result

class CharactersAdapter(
    private val onClickItem: OnClickItem
) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
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
        holder.bind(
            item = item,
            onClickItem = onClickItem
        )
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(private val binding: ListItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Result, onClickItem: OnClickItem) {
            binding.result = item
            binding.root.setOnClickListener {
                onClickItem.selectedItem(name = item.name)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val binding: ListItemCharacterBinding =
                    DataBindingUtil.inflate(
                        layoutInflater, R.layout.list_item_character,
                        parent, false
                    )
                return ViewHolder(binding)
            }
        }
    }

}


interface OnClickItem {
    fun selectedItem(name: String)
}

