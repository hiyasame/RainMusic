package kim.bifrost.rain.rainmusic.api.source

import kim.bifrost.rain.rainmusic.api.IStandardMusicInfo

/**
 * kim.bifrost.rain.rainmusic.api.source.QQMusicSource
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 12:19
 **/
object QQMusicSource : IWebMusicSource {
    override val name: String
        get() = "QQ音乐"
    override val code: Int
        get() = 1

    override fun search(query: String, limit: Int, offset: Int): List<IStandardMusicInfo> {
        TODO("Not yet implemented")
    }
}