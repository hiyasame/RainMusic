package kim.bifrost.rain.rainmusic.model.web.bean.netease

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class NeteaseLoginBean(
    val account: Account,
    val bindings: List<Binding>,
    // 正常为200
    val code: Int,
    val cookie: String,
    val loginType: Int,
    val profile: Profile,
    val token: String,
    // 登录失败显示的信息
    val message: String?
) : Serializable, Parcelable {

    data class Account(
        val anonimousUser: Boolean,
        val ban: Int,
        val baoyueVersion: Int,
        val createTime: Long,
        val donateVersion: Int,
        val id: Int,
        val salt: String,
        val status: Int,
        val tokenVersion: Int,
        val type: Int,
        val uninitialized: Boolean,
        val userName: String,
        val vipType: Int,
        val viptypeVersion: Long,
        val whitelistAuthority: Int
    ) : Serializable

    data class Binding(
        val bindingTime: Long,
        val expired: Boolean,
        val expiresIn: Int,
        val id: Long,
        val refreshTime: Int,
        val tokenJsonStr: String,
        val type: Int,
        val url: String,
        val userId: Int
    ) : Serializable

    data class Profile(
        val accountStatus: Int,
        val authStatus: Int,
        val authority: Int,
        val avatarDetail: Any,
        val avatarImgId: Long,
        val avatarImgIdStr: String,
        val avatarImgId_str: String,
        val avatarUrl: String,
        val backgroundImgId: Long,
        val backgroundImgIdStr: String,
        val backgroundUrl: String,
        val birthday: Int,
        val city: Int,
        val defaultAvatar: Boolean,
        val description: String,
        val detailDescription: String,
        val djStatus: Int,
        val eventCount: Int,
        val expertTags: Any,
        val followed: Boolean,
        val followeds: Int,
        val follows: Int,
        val gender: Int,
        val mutual: Boolean,
        val nickname: String,
        val playlistBeSubscribedCount: Int,
        val playlistCount: Int,
        val province: Int,
        val remarkName: Any,
        val signature: String,
        val userId: Int,
        val userType: Int,
        val vipType: Int
    ) : Serializable
}