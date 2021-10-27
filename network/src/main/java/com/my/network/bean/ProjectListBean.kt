package com.my.network.bean


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProjectListBean(
    @Json(name = "data")
    val `data`: List<ProjectBean>?,
    @Json(name = "errorCode")
    val errorCode: Int?,
    @Json(name = "errorMsg")
    val errorMsg: String?
)


@JsonClass(generateAdapter = true)
data class ProjectBean(
    @Json(name = "children")
    val children: List<Any>?,
    @Json(name = "courseId")
    val courseId: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "order")
    val order: Int?,
    @Json(name = "parentChapterId")
    val parentChapterId: Int?,
    @Json(name = "userControlSetTop")
    val userControlSetTop: Boolean?,
    @Json(name = "visible")
    val visible: Int?
)