package kim.bifrost.rain.rainmusic.api

import kim.bifrost.rain.rainmusic.api.source.IMusicSource

/**
 * kim.bifrost.rain.rainmusic.api.StandardMusicInfo
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/24 11:27
 **/
interface IStandardMusicInfo : StandardData<StandardMusicInfo> {
    /**
     * 音乐来源
     */
    val source: IMusicSource

    /**
     * 图片url
     */
    val imageUrl: String

    /**
     * 曲名
     */
    val name: String

    /**
     * 艺术家
     */
    val artists: List<IStandardMusicInfo>

    /**
     * 是否需要vip
     */
    val requireVip: Boolean

    /**
     * 网络音乐url/本地音乐路径
     */
    val musicPath: String

    override fun convertToStandardImpl(): StandardMusicInfo {
        return StandardMusicInfo(source, imageUrl, artists, requireVip, musicPath, name)
    }
}

interface IStandardArtistInfo : StandardData<StandardArtistInfo> {
    /**
     * 艺术家名称
     */
    val name: String

    /**
     * 艺术家介绍
     */
    val description: String

    /**
     * 艺术家头像
     */
    val avatarUrl: String

    override fun convertToStandardImpl(): StandardArtistInfo {
        return StandardArtistInfo(name, description, avatarUrl)
    }
}

data class StandardMusicInfo(
    override val source: IMusicSource,
    override val imageUrl: String,
    override val artists: List<IStandardMusicInfo>,
    override val requireVip: Boolean,
    override val musicPath: String,
    override val name: String
) : IStandardMusicInfo

data class StandardArtistInfo(
    override val name: String,
    override val description: String,
    override val avatarUrl: String
) : IStandardArtistInfo