package kim.bifrost.rain.rainmusic.model.web.bean.netease

import kim.bifrost.rain.rainmusic.api.IStandardArtistInfo
import kim.bifrost.rain.rainmusic.api.IStandardMusicInfo
import kim.bifrost.rain.rainmusic.api.source.IMusicSource
import kim.bifrost.rain.rainmusic.api.source.NeteaseMusicSource
import java.io.Serializable

data class NeteaseNewSongBean(
    val category: Int,
    val code: Int,
    val result: List<Result>
) : Serializable {
    data class Result(
        val alg: String,
        val canDislike: Boolean,
        val copywriter: Any,
        val id: Int,
        override val name: String,
        val picUrl: String,
        val song: Song,
        val trackNumberUpdateTime: Any,
        val type: Int,
    ) : Serializable, IStandardMusicInfo {
        override val musicId: Int
            get() = id
        override val source: IMusicSource
            get() = NeteaseMusicSource
        override val imageUrl: String
            get() = picUrl
        override val artists: List<IStandardArtistInfo>
            get() = song.artists
        override val requireVip: Boolean
            get() = false

        data class Song(
            val album: Album,
            val alias: List<String>,
            val artists: List<Artist>,
            val audition: Any,
            val bMusic: BMusic,
            val commentThreadId: String,
            val copyFrom: String,
            val copyright: Int,
            val copyrightId: Int,
            val crbt: Any,
            val dayPlays: Int,
            val disc: String,
            val duration: Int,
            val exclusive: Boolean,
            val fee: Int,
            val ftype: Int,
            val hMusic: HMusic,
            val hearTime: Int,
            val id: Int,
            val lMusic: LMusic,
            val mMusic: MMusic,
            val mark: Int,
            val mp3Url: Any,
            val mvid: Int,
            val name: String,
            val no: Int,
            val noCopyrightRcmd: Any,
            val originCoverType: Int,
            val originSongSimpleData: Any,
            val playedNum: Int,
            val popularity: Int,
            val position: Int,
            val privilege: Privilege,
            val ringtone: String,
            val rtUrl: Any,
            val rtUrls: List<Any>,
            val rtype: Int,
            val rurl: Any,
            val score: Int,
            val sign: Any,
            val single: Int,
            val starred: Boolean,
            val starredNum: Int,
            val status: Int,
            val transName: Any,
            val transNames: List<String>
        ) : Serializable {
            data class Album(
                val alias: List<String>,
                val artist: Artist,
                val artists: List<Artist>,
                val blurPicUrl: String,
                val briefDesc: String,
                val commentThreadId: String,
                val company: String,
                val companyId: Int,
                val copyrightId: Int,
                val description: String,
                val id: Int,
                val mark: Int,
                val name: String,
                val onSale: Boolean,
                val pic: Long,
                val picId: Long,
                val picId_str: String,
                val picUrl: String,
                val publishTime: Long,
                val size: Int,
                val songs: List<Any>,
                val status: Int,
                val subType: String,
                val tags: String,
                val transName: Any,
                val type: String
            ) : Serializable {
                data class Artist(
                    val albumSize: Int,
                    val alias: List<Any>,
                    val briefDesc: String,
                    val id: Int,
                    val img1v1Id: Int,
                    val img1v1Url: String,
                    val musicSize: Int,
                    val name: String,
                    val picId: Int,
                    val picUrl: String,
                    val topicPerson: Int,
                    val trans: String
                ) : Serializable
            }

            data class Artist(
                val albumSize: Int,
                val alias: List<Any>,
                val briefDesc: String,
                val id: Int,
                val img1v1Id: Int,
                val img1v1Url: String,
                val musicSize: Int,
                override val name: String,
                val picId: Int,
                val picUrl: String,
                val topicPerson: Int,
                val trans: String
            ) : Serializable, IStandardArtistInfo {
                override val description: String
                    get() = briefDesc
                override val avatarUrl: String
                    get() = picUrl
            }

            data class BMusic(
                val bitrate: Int,
                val dfsId: Int,
                val extension: String,
                val id: Long,
                val name: Any,
                val playTime: Int,
                val size: Int,
                val sr: Int,
                val volumeDelta: Int
            ) : Serializable

            data class HMusic(
                val bitrate: Int,
                val dfsId: Int,
                val extension: String,
                val id: Long,
                val name: Any,
                val playTime: Int,
                val size: Int,
                val sr: Int,
                val volumeDelta: Int
            ) : Serializable

            data class LMusic(
                val bitrate: Int,
                val dfsId: Int,
                val extension: String,
                val id: Long,
                val name: Any,
                val playTime: Int,
                val size: Int,
                val sr: Int,
                val volumeDelta: Int
            ) : Serializable

            data class MMusic(
                val bitrate: Int,
                val dfsId: Int,
                val extension: String,
                val id: Long,
                val name: Any,
                val playTime: Int,
                val size: Int,
                val sr: Int,
                val volumeDelta: Int
            ) : Serializable

            data class Privilege(
                val chargeInfoList: List<ChargeInfo>,
                val cp: Int,
                val cs: Boolean,
                val dl: Int,
                val downloadMaxbr: Int,
                val fee: Int,
                val fl: Int,
                val flag: Int,
                val freeTrialPrivilege: FreeTrialPrivilege,
                val id: Int,
                val maxbr: Int,
                val payed: Int,
                val pl: Int,
                val playMaxbr: Int,
                val preSell: Boolean,
                val rscl: Any,
                val sp: Int,
                val st: Int,
                val subp: Int,
                val toast: Boolean
            ) : Serializable {
                data class ChargeInfo(
                    val chargeMessage: Any,
                    val chargeType: Int,
                    val chargeUrl: Any,
                    val rate: Int
                ) : Serializable

                data class FreeTrialPrivilege(
                    val resConsumable: Boolean,
                    val userConsumable: Boolean
                ) : Serializable
            }
        }
    }
}