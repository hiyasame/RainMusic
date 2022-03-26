package kim.bifrost.rain.rainmusic.model.web.api

import com.google.gson.JsonObject
import kim.bifrost.rain.rainmusic.api.user.NeteaseUser
import kim.bifrost.rain.rainmusic.model.web.RetrofitHelper
import kim.bifrost.rain.rainmusic.model.web.bean.netease.NeteaseLoginBean
import kim.bifrost.rain.rainmusic.utils.extensions.md5
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/24 11:21
 **/
interface NeteaseCloudApi {
    /**
     * 登录
     * 安全起见 密码一律使用md5散列
     *
     * @param phone
     * @param password
     * @param md5Password
     * @param captcha
     */
    @FormUrlEncoded
    @POST("/login/cellphone")
    suspend fun loginByPhone(
        @Field("phone") phone: Int,
        password: String?,
        @Field("md5_password") md5Password: String? = password?.md5(),
        @Field("captcha") captcha: String? = null
    ): NeteaseLoginBean

    companion object : NeteaseCloudApi by RetrofitHelper.neteaseCloudApi {

        var user: NeteaseUser? = null

        fun updateUserInfo(info: NeteaseLoginBean) {
            user = NeteaseUser(info)
        }
    }
}