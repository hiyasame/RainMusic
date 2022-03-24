package kim.bifrost.rain.rainmusic.model.web

import kim.bifrost.rain.rainmusic.model.web.api.OthersApi
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

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://olbb.vercel.app")
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

}