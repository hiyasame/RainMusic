package kim.bifrost.rain.rainmusic.view.viewmodel

import androidx.lifecycle.ViewModel
import kim.bifrost.rain.rainmusic.model.web.api.OthersApi

/**
 * kim.bifrost.rain.rainmusic.view.viewmodel.SplashFragViewModel
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/23 1:12
 **/
class SplashFragViewModel : ViewModel() {
    suspend fun getPoem() = OthersApi.getPoem()
}