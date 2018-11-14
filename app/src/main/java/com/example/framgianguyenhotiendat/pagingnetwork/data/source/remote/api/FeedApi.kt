package com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.api

import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.message.WrapperResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedApi {
    @GET("/v2/everything")
    fun fetchFeed(@Query("q") q: String,
                  @Query("apiKey") apiKey: String,
                  @Query("page") page: Long,
                  @Query("pageSize") pageSize: Int) : Single<WrapperResponse>
}
