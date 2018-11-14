package com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.message

import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Article
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WrapperResponse(
        @SerializedName("status")
        @Expose
        var status: String,
        @SerializedName("totalResults")
        @Expose
        var totalResults: Int,
        @SerializedName("articles")
        @Expose
        var articles: List<Article>? = null)