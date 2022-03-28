package kim.bifrost.rain.rainmusic.model.web.interceptor

import kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi
import kim.bifrost.rain.rainmusic.utils.Constant
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response

/**
 * kim.bifrost.rain.rainmusic.model.web.interceptor.NeteaseInterceptor
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 13:21
 **/
class NeteaseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url
        if (url.toString().startsWith(Constant.BASE_URL_NETEASE) && NeteaseCloudApi.user.value != null) {
            val builder = request.newBuilder()
            if (request.method == "GET") {
                builder.url(
                    url.newBuilder()
                        .addQueryParameter("cookie", NeteaseCloudApi.user.value!!.cookie)
                        .build()
                )
            } else if (request.method == "POST") {
                val origin = request.body as FormBody
                val bodyBuilder = FormBody.Builder()
                for (i in 0 until origin.size) {
                    bodyBuilder.addEncoded(origin.encodedName(i), origin.encodedValue(i))
                }
                bodyBuilder.add("cookie", NeteaseCloudApi.user.value!!.cookie)
                builder.post(bodyBuilder.build())
            }
            request = builder.build()
        }
        return chain.proceed(request)
    }
}