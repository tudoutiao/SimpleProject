import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsChannelsBean(
    @Json(name = "data")
    val `data`: Data?,
    @Json(name = "errorCode")
    val errorCode: Int?,
    @Json(name = "errorMsg")
    val errorMsg: String?
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "curPage")
    val curPage: Int?,
    @Json(name = "datas")
    val datas: List<DataX>?,
    @Json(name = "offset")
    val offset: Int?,
    @Json(name = "over")
    val over: Boolean?,
    @Json(name = "pageCount")
    val pageCount: Int?,
    @Json(name = "size")
    val size: Int?,
    @Json(name = "total")
    val total: Int?
)

@JsonClass(generateAdapter = true)
data class DataX(
    @Json(name = "apkLink")
    val apkLink: String?,
    @Json(name = "audit")
    val audit: Int?,
    @Json(name = "author")
    val author: String?,
    @Json(name = "canEdit")
    val canEdit: Boolean?,
    @Json(name = "chapterId")
    val chapterId: Int?,
    @Json(name = "chapterName")
    val chapterName: String?,
    @Json(name = "collect")
    val collect: Boolean?,
    @Json(name = "courseId")
    val courseId: Int?,
    @Json(name = "desc")
    val desc: String?,
    @Json(name = "descMd")
    val descMd: String?,
    @Json(name = "envelopePic")
    val envelopePic: String?,
    @Json(name = "fresh")
    val fresh: Boolean?,
    @Json(name = "host")
    val host: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "niceDate")
    val niceDate: String?,
    @Json(name = "niceShareDate")
    val niceShareDate: String?,
    @Json(name = "origin")
    val origin: String?,
    @Json(name = "prefix")
    val prefix: String?,
    @Json(name = "projectLink")
    val projectLink: String?,
    @Json(name = "publishTime")
    val publishTime: Long?,
    @Json(name = "realSuperChapterId")
    val realSuperChapterId: Int?,
    @Json(name = "selfVisible")
    val selfVisible: Int?,
    @Json(name = "shareDate")
    val shareDate: Long?,
    @Json(name = "shareUser")
    val shareUser: String?,
    @Json(name = "superChapterId")
    val superChapterId: Int?,
    @Json(name = "superChapterName")
    val superChapterName: String?,
    @Json(name = "tags")
    val tags: List<Tag>?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "type")
    val type: Int?,
    @Json(name = "userId")
    val userId: Int?,
    @Json(name = "visible")
    val visible: Int?,
    @Json(name = "zan")
    val zan: Int?
)

@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "name")
    val name: String?,
    @Json(name = "url")
    val url: String?
)