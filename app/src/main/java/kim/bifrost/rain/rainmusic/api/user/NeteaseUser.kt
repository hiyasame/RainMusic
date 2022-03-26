package kim.bifrost.rain.rainmusic.api.user

import kim.bifrost.rain.rainmusic.model.web.bean.netease.NeteaseLoginBean

/**
 * kim.bifrost.rain.rainmusic.api.user.NeteaseUser
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 12:52
 **/
class NeteaseUser(private val bean: NeteaseLoginBean) : User {

    override val cookie: String
        get() = bean.cookie

    override val isVip: Boolean
        get() = bean.profile.vipType != 0

    override val profile: UserProfile = UserProfile(
        name = bean.profile.nickname,
        avatar = bean.profile.avatarUrl
    )

}