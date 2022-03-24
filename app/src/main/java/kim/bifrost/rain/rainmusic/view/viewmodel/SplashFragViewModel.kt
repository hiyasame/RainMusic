package kim.bifrost.rain.rainmusic.view.viewmodel

import kim.bifrost.rain.rainmusic.base.ui.BaseViewModel
import kim.bifrost.rain.rainmusic.model.web.api.OthersApi

/**
 * kim.bifrost.rain.rainmusic.view.viewmodel.SplashFragViewModel
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/23 1:12
 **/
class SplashFragViewModel : BaseViewModel() {

    val mPoemData = liveDataLaunch {
        OthersApi.getPoem()
    }
}