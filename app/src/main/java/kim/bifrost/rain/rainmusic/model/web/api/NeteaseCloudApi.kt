package kim.bifrost.rain.rainmusic.model.web.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kim.bifrost.rain.rainmusic.api.user.NeteaseUser
import kim.bifrost.rain.rainmusic.base.App
import kim.bifrost.rain.rainmusic.model.web.RetrofitHelper
import kim.bifrost.rain.rainmusic.model.web.bean.netease.*
import kim.bifrost.rain.rainmusic.utils.Constant
import kim.bifrost.rain.rainmusic.utils.extensions.md5
import retrofit2.http.*

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
     * @param md5Password
     * @param captcha
     */
    @FormUrlEncoded
    @POST(Constant.NETEASE_LOGIN_PHONE)
    suspend fun loginByPhone(
        @Field("phone") phone: String,
        @Field("md5_password") md5Password: String? = null,
        @Field("captcha") captcha: String? = null
    ): NeteaseLoginBean

    /**
     * 刷新登录状态
     *
     */
    @GET(Constant.NETEASE_REFRESH_LOGIN_STATE)
    suspend fun refreshLogin()

    /**
     * 发送验证码
     *
     * @param phone
     */
    @GET(Constant.NETEASE_CAPTCHA_SENT)
    suspend fun sendCaptcha(
        @Query("phone") phone: String
    ): NeteaseVerifyActionResult

    /**
     * 验证验证码是否正确
     *
     * @param phone
     * @param captcha
     * @return
     */
    @GET(Constant.NETEASE_CAPTCHA_VERIFY)
    suspend fun verifyCaptcha(
        @Query("phone") phone: String,
        @Query("captcha") captcha: String
    ): NeteaseVerifyActionResult

    /**
     * 获取用户歌单
     * 登录才能获取私有歌单
     *
     * @param uid
     * @return
     */
    @GET(Constant.NETEASE_USER_PLAYLIST)
    suspend fun getUserPlayList(
        @Query("uid") uid: Int
    ): NeteasePlayListBean

    /**
     * 获取每日推荐曲目
     */
    @GET(Constant.NETEASE_RECOMMEND_SONG)
    suspend fun getRecommendSong(): NeteaseDailySongBean

    /**
     * 获取推荐歌单
     *
     * @param limit 数量限制
     * @return
     */
    @GET(Constant.NETEASE_RECOMMEND_LIST)
    suspend fun getRecommendPlayList(
        @Query("limit") limit: Int = 16
    ): NeteaseRecommendPlayListBean

    /**
     * 获取新歌
     *
     * @return
     */
    @GET(Constant.NETEASE_NEW_SONG)
    suspend fun getNewSongs(): NeteaseNewSongBean

    companion object : NeteaseCloudApi by RetrofitHelper.neteaseCloudApi {

        val user = MutableLiveData<NeteaseUser?>()

        val hasLogin: Boolean
            get() = user.value != null

        suspend fun login(
            phone: String,
            password: String? = null,
            captcha: String? = null
        ): NeteaseLoginBean {
            val info = RetrofitHelper.neteaseCloudApi.loginByPhone(phone, password?.md5(), captcha)
            if (info.code == 200) {
                user.value = NeteaseUser(info)
                App.mmkv.encode("login", info)
            }
            return info
        }

    }
}