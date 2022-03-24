package kim.bifrost.rain.rainmusic.model.web.api

import kim.bifrost.rain.rainmusic.model.web.RetrofitHelper
import kim.bifrost.rain.rainmusic.model.web.bean.PoemBean
import retrofit2.http.GET
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

    @GET("https://v1.hitokoto.cn/")
    suspend fun getPoem(@Query("c") c: String = "i", @Query("encode") encode: String = "json"): PoemBean

    companion object : OthersApi by RetrofitHelper.othersApi
}