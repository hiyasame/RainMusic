package kim.bifrost.rain.rainmusic.api

/**
 * kim.bifrost.rain.rainmusic.api.CachedMusicInfo
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/24 11:56
 **/
data class CachedMusicInfo(
    // 缓存路径
    val path: String,
    // 文件大小
    val size: Long
)
