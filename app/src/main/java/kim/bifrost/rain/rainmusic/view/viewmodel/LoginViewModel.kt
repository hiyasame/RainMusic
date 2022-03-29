package kim.bifrost.rain.rainmusic.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi

/**
 * kim.bifrost.rain.rainmusic.view.viewmodel.LoginViewModel
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/28 10:49
 **/
class LoginViewModel : ViewModel() {
    val loginState: MutableLiveData<LoginScreenState> = MutableLiveData()

    suspend fun neteaseLogin(phone: String, pass: String? = null, captcha: String? = null) =
        NeteaseCloudApi.login(
            phone = phone,
            password = pass,
            captcha = captcha
        )

    suspend fun neteaseSendCaptcha(phone: String) = NeteaseCloudApi.sendCaptcha(phone)

    suspend fun neteaseVerifyCaptcha(phone: String, code: String) = NeteaseCloudApi.verifyCaptcha(phone, code)
}

enum class LoginScreenState {
    START, NETEASE, QQ
}