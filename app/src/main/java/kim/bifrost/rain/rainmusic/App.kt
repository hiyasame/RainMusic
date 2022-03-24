package kim.bifrost.rain.rainmusic

import android.app.Application
import android.content.Context

/**
 * kim.bifrost.rain.rainmusic.App
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/24 11:19
 **/
class App : Application() {

    lateinit var context: Context
        private set

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}