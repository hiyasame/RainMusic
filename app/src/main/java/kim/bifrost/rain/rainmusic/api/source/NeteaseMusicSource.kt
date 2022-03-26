package kim.bifrost.rain.rainmusic.api.source

/**
 * kim.bifrost.rain.rainmusic.api.source.NeteaseMusicSource
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 12:20
 **/
object NeteaseMusicSource : IWebMusicSource {
    override val name: String
        get() = "网易云音乐"
    override val code: Int
        get() = 2
}