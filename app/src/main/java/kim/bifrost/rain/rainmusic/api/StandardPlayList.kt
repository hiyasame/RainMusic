package kim.bifrost.rain.rainmusic.api

/**
 * kim.bifrost.rain.rainmusic.api.StandardPlayList
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/27 1:16
 **/
interface IStandardPlayList : StandardData<StandardPlayList> {
    // cover
    val coverImgUrl: String

    // 歌单名
    val name: String

    // 歌单
    val count: Int

    // 播放量
    val playCounts: Long

    override suspend fun convertToStandardImpl(): StandardPlayList {
        return StandardPlayList(coverImgUrl, name, count, playCounts)
    }
}

data class StandardPlayList(
    override val coverImgUrl: String,
    override val name: String,
    override val count: Int,
    override val playCounts: Long
): IStandardPlayList

