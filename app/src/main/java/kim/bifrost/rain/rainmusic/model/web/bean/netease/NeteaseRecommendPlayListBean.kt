package kim.bifrost.rain.rainmusic.model.web.bean.netease

import kim.bifrost.rain.rainmusic.api.IStandardPlayList
import java.io.Serializable

data class NeteaseRecommendPlayListBean(
    val category: Int,
    val code: Int,
    val hasTaste: Boolean,
    val result: List<Result>
) : Serializable {
    data class Result(
        val alg: String,
        val canDislike: Boolean,
        val copywriter: Any,
        val highQuality: Boolean,
        val id: Long,
        override val name: String,
        val picUrl: String,
        val playCount: Long,
        val trackCount: Int,
        val trackNumberUpdateTime: Long,
        val type: Int,
    ) : Serializable, IStandardPlayList {
        override val coverImgUrl: String
            get() = picUrl
        override val count: Int
            get() = trackCount
        override val playCounts: Long
            get() = playCount
    }
}