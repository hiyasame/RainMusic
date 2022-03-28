package kim.bifrost.rain.rainmusic.view.viewmodel

import androidx.lifecycle.ViewModel
import kim.bifrost.rain.rainmusic.api.user.NeteaseUser
import kim.bifrost.rain.rainmusic.base.App
import kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi
import kim.bifrost.rain.rainmusic.model.web.bean.netease.NeteaseLoginBean

/**
 * kim.bifrost.rain.rainmusic.view.viewmodel.MyFragViewModel
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 22:19
 **/
class MyFragViewModel : ViewModel() {
    fun initUser() {
        val bean = App.mmkv.decodeParcelable("login", NeteaseLoginBean::class.java)
        if (bean != null) {
            NeteaseCloudApi.user.value = NeteaseUser(bean)
        }
    }

    suspend fun getUserPlayList(uid: Int) = NeteaseCloudApi.getUserPlayList(uid)
}