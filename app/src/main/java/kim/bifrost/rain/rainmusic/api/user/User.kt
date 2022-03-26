package kim.bifrost.rain.rainmusic.api.user

/**
 * kim.bifrost.rain.rainmusic.api.user.User
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 12:07
 **/
interface User {
    /**
     * cookie
     */
    val cookie: String

    /**
     * 是否为vip
     */
    val isVip: Boolean

    /**
     * 用户信息
     */
    val profile: UserProfile
}

data class UserProfile(
    /**
     * 用户名
     */
    val name: String,
    /**
     * 头像
     */
    val avatar: String,
)