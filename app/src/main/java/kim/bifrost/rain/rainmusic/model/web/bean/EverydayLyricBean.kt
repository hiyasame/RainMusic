package kim.bifrost.rain.rainmusic.model.web.bean

import java.io.Serializable

data class EverydayLyricBean(
    val `data`: Data,
    val err_no: Int,
    val msg: String
) : Serializable {
    data class Data(
        val content: String,
        val singer: String,
        val song: String,
        val writer: String
    ) : Serializable
}