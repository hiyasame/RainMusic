package kim.bifrost.rain.rainmusic.api.source

import kim.bifrost.rain.rainmusic.api.IStandardMusicInfo

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
    /**
     * 搜索音乐
     *
     * @param query
     * @param limit
     * @param offset
     * @return
     */
    fun search(query: String, limit: Int, offset: Int): List<IStandardMusicInfo>
}
