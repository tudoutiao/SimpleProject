package com.my.news.api

import NewsChannelsBean
import com.my.network.apiresponse.NetworkResponse
import com.my.network.bean.ProjectListBean
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApiInterface {

    @GET("project/tree/json")
    suspend fun getProjectTree():NetworkResponse<ProjectListBean>

    @GET("project/list/{page}/json")
    suspend fun getNewsChannels(
        @Path("page") page: Int,
        @Query("cid") cid: String

    ): NetworkResponse<NewsChannelsBean>

}