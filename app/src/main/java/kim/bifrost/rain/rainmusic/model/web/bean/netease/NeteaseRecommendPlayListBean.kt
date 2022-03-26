package kim.bifrost.rain.rainmusic.model.web.bean.netease

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
        val name: String,
        val picUrl: String,
        val playCount: Int,
        val trackCount: Int,
        val trackNumberUpdateTime: Long,
        val type: Int
    ) : Serializable
}