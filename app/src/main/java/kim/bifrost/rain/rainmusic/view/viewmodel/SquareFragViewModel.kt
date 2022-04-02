package kim.bifrost.rain.rainmusic.view.viewmodel

import androidx.lifecycle.ViewModel
import kim.bifrost.rain.rainmusic.api.user.User
import kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi
import kim.bifrost.rain.rainmusic.model.web.api.OthersApi

/**
 * kim.bifrost.rain.rainmusic.view.viewmodel.SquareFragViewModel
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 22:21
 **/
class SquareFragViewModel : ViewModel() {
    suspend fun getRecommendPlayList() = NeteaseCloudApi.getRecommendPlayList().result

    suspend fun getNewSongs() = NeteaseCloudApi.getNewSongs().result

    suspend fun getLyrics() = OthersApi.getEveryDayLyric()
}