package kim.bifrost.rain.rainmusic.utils

/**
 * kim.bifrost.rain.rainmusic.utils.Constant
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 13:24
 **/
object Constant {
    // 网易云服务 baseurl
    const val BASE_URL_NETEASE = "https://olbb.vercel.app"

    // 手机登录
    const val NETEASE_LOGIN_PHONE = "/login/cellphone"
    // 刷新登录状态
    const val NETEASE_REFRESH_LOGIN_STATE = "/login/refresh"
    // 发送验证码
    const val NETEASE_CAPTCHA_SENT = "/captcha/sent"
    // 验证验证码
    const val NETEASE_CAPTCHA_VERIFY = "/captcha/verify"
    // 获取用户歌单
    const val NETEASE_USER_PLAYLIST = "/user/playlist"
    // 获取个性推荐歌单
    const val NETEASE_RECOMMEND_LIST = "/personalized"
    // 获取每日推荐单曲
    const val NETEASE_RECOMMEND_SONG = "/recommend/songs"
    // 获取每日推荐新曲
    const val NETEASE_NEW_SONG = "/personalized/newsong"
}