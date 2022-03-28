package kim.bifrost.rain.rainmusic.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * kim.bifrost.rain.rainmusic.view.viewmodel.LoginViewModel
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/28 10:49
 **/
class LoginViewModel : ViewModel() {

    companion object {
        val loginState: MutableLiveData<LoginScreenState> = MutableLiveData()
    }
}

enum class LoginScreenState {
    START, NETEASE, QQ
}