package com.example.framgianguyenhotiendat.pagingnetwork.ui.apiload

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Article
import com.example.framgianguyenhotiendat.pagingnetwork.databinding.ItemArticleBinding

class FeedAdapter : PagedListAdapter<Article, FeedHolder>(ARTICLE_DIFF) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FeedHolder(
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FeedHolder, position: Int) {
        // item here can be null because PagedList config allowed null to set PlaceHolder
        holder.bindView(getItem(position))
    }

    companion object {
        private val ARTICLE_DIFF = object : DiffUtil.ItemCallback<Article>() {
            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.url == newItem.url
            }

        }
    }
}
