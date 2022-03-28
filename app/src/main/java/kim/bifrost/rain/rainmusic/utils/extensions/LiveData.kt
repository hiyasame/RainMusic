package kim.bifrost.rain.rainmusic.utils.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KProperty

/**
 * kim.bifrost.rain.rainmusic.utils.extensions.LiveData
 * RainMusic
 * LiveData 代理
 *
 * @author 寒雨
 * @since 2022/3/27 1:58
 **/
operator fun <T> LiveData<T>.getValue(thisRef: Any?, property: KProperty<*>): T? {
    return value
}

operator fun <T> MutableLiveData<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.value = value
}