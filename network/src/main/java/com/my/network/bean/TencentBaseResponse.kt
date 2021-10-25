package com.my.network.bean

import com.squareup.moshi.Json

class TencentBaseResponse(
    @Json(name = "errorCode")
    val errorCode: Int?,
    @Json(name = "errorMsg")
    val errorMsg: String?
)





