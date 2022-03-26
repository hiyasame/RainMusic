package kim.bifrost.rain.rainmusic.base

import android.app.Application
import android.content.Context
import com.tencent.mmkv.MMKV

/**
 * kim.bifrost.rain.rainmusic.base.App
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/24 11:19
 **/
class App : Application() {

    companion object {
        // 这里最好不要与 context 命名相同
        lateinit var appContext: Context
            private set

        // mmkv 键值数据库
        lateinit var mmkv: MMKV
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        MMKV.initialize(appContext)
        mmkv = MMKV.defaultMMKV()
    }
}