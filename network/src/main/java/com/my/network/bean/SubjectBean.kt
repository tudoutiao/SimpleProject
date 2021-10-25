package com.my.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SubjectBean(
    @Json(name = "message")
    val message: String? = null,

    @Json(name = "code")
    val code: Int? = null,

    @Json(name = "subjects")
    val subjects: List<Subject>? = null
)


@JsonClass(generateAdapter = true)
data class Subject(
    @Json(name = "action")
    val action: Int?,
    @Json(name = "actionTime")
    val actionTime: Long?,
    @Json(name = "createTime")
    val createTime: Long?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "enName")
    val enName: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: Int?,
    @Json(name = "imgUrl")
    val imgUrl: String?,
    @Json(name = "link")
    val link: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "name_cn")
    val nameCn: String?,
    @Json(name = "name_en")
    val nameEn: String?,
    @Json(name = "_prefix")
    val prefix: Boolean?,
    @Json(name = "release")
    val release: Int?,
    @Json(name = "sort")
    val sort: Int?,
    @Json(name = "story")
    val story: Int?,
    @Json(name = "supportImage")
    val supportImage: Boolean?,
    @Json(name = "supportLink")
    val supportLink: Boolean?,
    @Json(name = "supportWord")
    val supportWord: Boolean?,
    @Json(name = "uri")
    val uri: String?,
    @Json(name = "word")
    val word: Int?
)