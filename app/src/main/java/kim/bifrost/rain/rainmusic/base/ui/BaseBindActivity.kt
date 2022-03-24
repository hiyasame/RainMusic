package kim.bifrost.rain.rainmusic.base.ui

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import kim.bifrost.rain.rainmusic.utils.extensions.invokeStatic
import kim.bifrost.rain.rainmusic.utils.extensions.lazyUnlock

/**
 * .....
 * @author 985892345
 * @email 2767465918@qq.com
 * @data 2021/6/2
 */
abstract class BaseBindActivity<DB: ViewBinding>(
    /**
     * 是否锁定竖屏
     */
    isPortraitScreen: Boolean = true,

    /**
     * 是否沉浸式状态栏
     */
    isCancelStatusBar: Boolean = true
) : BaseActivity(isPortraitScreen, isCancelStatusBar) {

    /**
     * 用于在调用 [setContentView] 之前的方法, 可用于设置一些主题或窗口的东西, 放这里不会报错
     */
    open fun onSetContentViewBefore() {}

    protected val binding: DB by lazyUnlock {
        getGenericClassFromSuperClass<ViewBinding>().invokeStatic<DB>("inflate", layoutInflater)!!
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onSetContentViewBefore()
        setContentView(binding.root)
    }
}