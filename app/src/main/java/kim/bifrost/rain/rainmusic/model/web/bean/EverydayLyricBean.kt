package kim.bifrost.rain.rainmusic.model.web.bean

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class EverydayLyricBean(
    val `data`: Data,
    val err_no: Int,
    val msg: String
) : Serializable, Parcelable {
    data class Data(
        val content: String,
        val singer: String,
        val song: String,
        val writer: String
    ) : Serializable
}