package kim.bifrost.rain.rainmusic.api.source

/**
 * kim.bifrost.rain.rainmusic.api.source.LocalSource
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 12:19
 **/
object LocalSource : IMusicSource {
    override val name: String
        get() = "本地"
    override val code: Int
        get() = 0
}