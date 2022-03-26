package kim.bifrost.rain.rainmusic.model.web.bean.netease

import java.io.Serializable

data class NeteaseVerifyActionResult(
    val message: String?,
    val code: Int,
    val `data`: Boolean
) : Serializable