package kim.bifrost.rain.rainmusic.model.web

import kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi
import kim.bifrost.rain.rainmusic.model.web.api.OthersApi
import kim.bifrost.rain.rainmusic.model.web.interceptor.NeteaseInterceptor
import kim.bifrost.rain.rainmusic.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * kim.bifrost.rain.rainmusic.model.web.RetrofitHelper
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/23 0:47
 **/
object RetrofitHelper {

    private val retrofit by lazy { initRetrofit() }
    val othersApi: OthersApi by lazy { retrofit.create(OthersApi::class.java) }
    val neteaseCloudApi: NeteaseCloudApi by lazy { retrofit.create(NeteaseCloudApi::class.java) }

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL_NETEASE)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(NeteaseInterceptor())
            .build()
    }

}