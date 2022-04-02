package kim.bifrost.rain.rainmusic.utils.extensions

import android.text.Html
import android.text.Spanned
import java.security.MessageDigest

/**
 * kim.bifrost.rain.rainmusic.utils.extensions.String
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/4/2 17:47
 **/
fun String.md5(): String {
    val hash = MessageDigest.getInstance("MD5").digest(toByteArray())
    val hex = StringBuilder(hash.size * 2)
    for (b in hash) {
        var str = Integer.toHexString(b.toInt())
        if (b < 0x10) {
            str = "0$str"
        }
        hex.append(str.substring(str.length -2))
    }
    return hex.toString()
}

fun String.htmlDecode(): Spanned = Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)