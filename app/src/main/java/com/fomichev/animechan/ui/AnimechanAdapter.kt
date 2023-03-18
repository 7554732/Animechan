package com.fomichev.animechan.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fomichev.animechan.databinding.AnimeItemBinding
import com.fomichev.animechan.repository.Anime

class AnimechanAdapter : RecyclerView.Adapter<AnimechanAdapter.AnimeViewHolder>() {
    var dataList: List<Anime> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val itemBinding = AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(itemBinding)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val dataItem = dataList[position]
        holder.bind(dataItem)
    }

    class AnimeViewHolder(private val itemBinding: AnimeItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(dataItem: Anime) {
            itemBinding.animeText.text = dataItem.anime
        }
    }

}

