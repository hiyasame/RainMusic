package kim.bifrost.rain.rainmusic.api.source

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
