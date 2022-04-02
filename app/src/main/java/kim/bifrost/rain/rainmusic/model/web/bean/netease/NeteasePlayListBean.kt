package kim.bifrost.rain.rainmusic.model.web.bean.netease

import kim.bifrost.rain.rainmusic.api.IStandardPlayList
import java.io.Serializable

data class NeteasePlayListBean(
    val code: Int,
    val more: Boolean,
    val playlist: List<Playlist>,
    val version: String
) : Serializable {
    data class Playlist(
        val adType: Int,
        val anonimous: Boolean,
        val backgroundCoverId: Long,
        val cloudTrackCount: Int,
        val commentThreadId: String,
        val coverImgId: Long,
        val coverImgId_str: String,
        override val coverImgUrl: String,
        val createTime: Long,
        val creator: Creator,
        val description: String,
        val highQuality: Boolean,
        val id: Long,
        override val name: String,
        val newImported: Boolean,
        val opRecommend: Boolean,
        val ordered: Boolean,
        val playCount: Long,
        val privacy: Int,
        val specialType: Int,
        val status: Int,
        val subscribed: Boolean,
        val subscribedCount: Int,
        val tags: List<String>,
        val titleImage: Long,
        val totalDuration: Int,
        val trackCount: Int,
        val trackNumberUpdateTime: Long,
        val trackUpdateTime: Long,
        val updateTime: Long,
        val userId: Int
    ) : Serializable, IStandardPlayList {
        override val count: Int = trackCount

        override val playCounts: Long
            get() = playCount

        data class Creator(
            val accountStatus: Int,
            val anchor: Boolean,
            val authStatus: Int,
            val authenticationTypes: Int,
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
            val expertTags: Any,
            val experts: Any,
            val followed: Boolean,
            val gender: Int,
            val mutual: Boolean,
            val nickname: String,
            val province: Int,
            val remarkName: Any,
            val signature: String,
            val userId: Int,
            val userType: Int,
            val vipType: Int
        ) : Serializable
    }
}