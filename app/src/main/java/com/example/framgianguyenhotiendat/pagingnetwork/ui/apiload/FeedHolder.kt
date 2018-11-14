package com.example.framgianguyenhotiendat.pagingnetwork.ui.apiload

import android.support.v7.widget.RecyclerView
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Article
import com.example.framgianguyenhotiendat.pagingnetwork.databinding.ItemArticleBinding

class FeedHolder constructor(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindView(item: Article?) {
        binding.run {
            article = item ?: Article()
            executePendingBindings()
        }
    }
}
