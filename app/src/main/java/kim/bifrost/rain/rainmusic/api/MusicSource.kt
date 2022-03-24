package kim.bifrost.rain.rainmusic.api

/**
 * kim.bifrost.rain.rainmusic.api.MusicSource
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/24 11:33
 **/
interface IMusicSource {
    // 名称
    val name: String
    // 音乐源代码
    val code: Int
}

interface IWebMusicSource : IMusicSource {
    // TODO: 获取网络数据的方法
}

object LocalMusicSource : IMusicSource {
    override val name: String
        get() = "本地"
    override val code: Int
        get() = 0
}

object QQMusicSource : IWebMusicSource {
    override val name: String
        get() = "QQ音乐"
    override val code: Int
        get() = 1
}

object NeteaseMusicSource : IWebMusicSource {
    override val name: String
        get() = "网易云音乐"
    override val code: Int
        get() = 2
}

// 在音乐区视频搜索
object BiliBiliMusicSource : IWebMusicSource {
    override val name: String
        get() = "BiliBili"
    override val code: Int
        get() = 3
}
