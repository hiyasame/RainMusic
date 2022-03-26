package kim.bifrost.rain.rainmusic.model.web.api

import kim.bifrost.rain.rainmusic.model.web.RetrofitHelper
import kim.bifrost.rain.rainmusic.model.web.bean.EverydayLyricBean
import kim.bifrost.rain.rainmusic.model.web.bean.PoemBean
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * kim.bifrost.rain.rainmusic.model.web.api.OthersApi
 * RainMusic
 * 通用API
 *
 * @author 寒雨
 * @since 2022/3/23 0:48
 **/
interface OthersApi {

    /**
     * 获取一首诗
     *
     * @param c
     * @param encode
     * @return
     */
    @GET("https://v1.hitokoto.cn/")
    suspend fun getPoem(@Query("c") c: String = "i", @Query("encode") encode: String = "json"): PoemBean

    /**
     * 获取每日推荐歌词
     *
     * @param token
     * @return
     */
    @GET("https://lemmon.cn/lyric")
    suspend fun getEveryDayLyric(@Header("token") token: String = "xVlurOqGx8CEmU5q87afxg=="): EverydayLyricBean

    companion object : OthersApi by RetrofitHelper.othersApi
}