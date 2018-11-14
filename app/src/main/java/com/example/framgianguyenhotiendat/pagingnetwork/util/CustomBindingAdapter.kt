package com.example.framgianguyenhotiendat.pagingnetwork.util

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.widget.CircularProgressDrawable
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.framgianguyenhotiendat.pagingnetwork.R

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context).load(url ?: "").apply(
            RequestOptions().placeholder(CircularProgressDrawable(view.context).apply {
                strokeWidth = 5f
                centerRadius = 30f
                start()
            }).error(ContextCompat.getDrawable(view.context, R.drawable.ic_error))
    ).into(view)
}

@BindingAdapter("itemDivider")
fun setItemDivider(view: RecyclerView, state: Boolean) {
    if (state) view.addItemDecoration(DividerItemDecoration(view.context, LinearLayoutManager.VERTICAL))
}
