package kim.bifrost.rain.rainmusic.model.web.bean.netease

import java.io.Serializable

data class NeteaseDailySongBean(
    val code: Int,
    val `data`: Data
) : Serializable {
    data class Data(
        val dailySongs: List<DailySong>,
        val orderSongs: List<Any>,
        val recommendReasons: List<RecommendReason>
    ) : Serializable {
        data class DailySong(
            val a: Any,
            val al: Al,
            val alg: String,
            val alia: List<String>,
            val ar: List<Ar>,
            val cd: String,
            val cf: String,
            val copyright: Int,
            val cp: Int,
            val crbt: Any,
            val djId: Int,
            val dt: Int,
            val fee: Int,
            val ftype: Int,
            val h: H,
            val id: Int,
            val l: L,
            val m: M,
            val mark: Int,
            val mst: Int,
            val mv: Int,
            val name: String,
            val no: Int,
            val noCopyrightRcmd: Any,
            val originCoverType: Int,
            val originSongSimpleData: Any,
            val pop: Int,
            val privilege: Privilege,
            val pst: Int,
            val publishTime: Long,
            val reason: String,
            val rt: Any,
            val rtUrl: Any,
            val rtUrls: List<Any>,
            val rtype: Int,
            val rurl: Any,
            val s_ctrp: String,
            val s_id: Int,
            val single: Int,
            val st: Int,
            val t: Int,
            val tns: List<String>,
            val v: Int
        ) : Serializable {
            data class Al(
                val id: Int,
                val name: String,
                val pic: Long,
                val picUrl: String,
                val pic_str: String,
                val tns: List<String>
            ) : Serializable

            data class Ar(
                val alias: List<Any>,
                val id: Int,
                val name: String,
                val tns: List<Any>
            ) : Serializable

            data class H(
                val br: Int,
                val fid: Int,
                val size: Int,
                val vd: Int
            ) : Serializable

            data class L(
                val br: Int,
                val fid: Int,
                val size: Int,
                val vd: Int
            ) : Serializable

            data class M(
                val br: Int,
                val fid: Int,
                val size: Int,
                val vd: Int
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

        data class RecommendReason(
            val reason: String,
            val songId: Int
        ) : Serializable
    }
}