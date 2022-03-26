package kim.bifrost.rain.rainmusic.api.source

/**
 * kim.bifrost.rain.rainmusic.api.source.BiliBiliSource
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 12:21
 **/
object BiliBiliSource : IWebMusicSource {
    override val name: String
    get() = "BiliBili"
    override val code: Int
    get() = 3
}