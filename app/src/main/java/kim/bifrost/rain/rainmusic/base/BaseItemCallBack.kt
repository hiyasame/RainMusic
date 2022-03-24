package kim.bifrost.rain.rainmusic.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import kim.bifrost.rain.rainmusic.utils.extensions.getProperty

/**
 * kim.bifrost.rain.rainmusic.base.BaseItemCallBack
 * WanAndroid
 *
 * @author 寒雨
 * @since 2021/12/4 11:24
 **/
open class BaseItemCallBack<T>(
    val func: (T, T) -> Boolean = { a, b ->
        defFunc(a as Any, b as Any)
    },
) : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return func(oldItem, newItem)
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    /**
     * 默认实现这个方法有一定的好处，避免每次刷新时都与缓存互换
     */
    override fun getChangePayload(oldItem: T, newItem: T): Any {
        return "" // 这里只要不传入 null 就可以了
    }
}

val defFunc: (Any, Any) -> Boolean = { a, b ->
    a.getProperty<Int>("id") == b.getProperty<Int>("id")
}