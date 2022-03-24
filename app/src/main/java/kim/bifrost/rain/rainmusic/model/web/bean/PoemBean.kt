package kim.bifrost.rain.rainmusic.model.web.bean

import java.io.Serializable

data class PoemBean(
    val commit_from: String,
    val created_at: String,
    val creator: String,
    val creator_uid: Int,
    val from: String,
    val from_who: String,
    val hitokoto: String,
    val id: Int,
    val length: Int,
    val reviewer: Int,
    val type: String,
    val uuid: String
) : Serializable