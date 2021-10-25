package com.my.myapp.api

import NewsChannelsBean
import com.my.network.apiresponse.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TencentNewsApiInterface {
    @GET("project/list/{page}/json")
    suspend fun getNewsChannels(
        @Path("page") page: Int,
        @Query("cid") cid: String

    ): NetworkResponse<NewsChannelsBean>
}