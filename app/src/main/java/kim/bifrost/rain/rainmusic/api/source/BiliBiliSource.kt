package kim.bifrost.rain.rainmusic.api.source

import kim.bifrost.rain.rainmusic.api.IStandardMusicInfo

/**
 * kim.bifrost.rain.rainmusic.api.source.BiliBiliSource
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 12:21
 **/
object BiliBiliSource : IWebMusicSource {
    override fun search(query: String, limit: Int, offset: Int): List<IStandardMusicInfo> {
        TODO("Not yet implemented")
    }

    override val name: String
        get() = "BiliBili"
    override val code: Int
        get() = 3
}