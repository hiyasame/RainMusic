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
     * 音乐id
     */
    val musicId: Int

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
    val artists: List<IStandardArtistInfo>

    /**
     * 是否需要vip
     */
    val requireVip: Boolean

    /**
     * 音乐本地路径
     * 没有下载就为null
     */
    suspend fun getMusicPath(): String? = null

    override suspend fun convertToStandardImpl(): StandardMusicInfo {
        return StandardMusicInfo(source, imageUrl, artists, requireVip, getMusicPath(), name, musicId)
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

    override suspend fun convertToStandardImpl(): StandardArtistInfo {
        return StandardArtistInfo(name, description, avatarUrl)
    }
}

data class StandardMusicInfo(
    override val source: IMusicSource,
    override val imageUrl: String,
    override val artists: List<IStandardArtistInfo>,
    override val requireVip: Boolean,
    val musicPath: String?,
    override val name: String,
    override val musicId: Int
) : IStandardMusicInfo

data class StandardArtistInfo(
    override val name: String,
    override val description: String,
    override val avatarUrl: String
) : IStandardArtistInfo