package kim.bifrost.rain.rainmusic.api

/**
 * kim.bifrost.rain.rainmusic.api.StandardData
 * RainMusic
 * 跨平台标准数据接口
 *
 * @author 寒雨
 * @since 2022/3/24 13:12
 **/
interface StandardData<T> {
    /**
     * 将其他平台实现转为标准实现
     * 方便扔进数据库
     *
     * @return
     */
    suspend fun convertToStandardImpl(): T
}