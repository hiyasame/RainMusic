package kim.bifrost.rain.rainmusic.view.viewmodel

import androidx.lifecycle.ViewModel
import kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi

/**
 * kim.bifrost.rain.rainmusic.view.viewmodel.SquareFragViewModel
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 22:21
 **/
class SquareFragViewModel : ViewModel() {
    suspend fun getRecommendPlayList(uid: Int) = NeteaseCloudApi.getRecommendPlayList().result
}