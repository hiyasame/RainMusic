package kim.bifrost.rain.rainmusic.base.ui.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kim.bifrost.rain.rainmusic.base.ui.BaseActivity

abstract class BaseVmActivity<VM: ViewModel>(
    /**
     * 是否锁定竖屏
     */
    isPortraitScreen: Boolean = true,

    /**
     * 是否沉浸式状态栏
     */
    isCancelStatusBar: Boolean = true,
) : BaseActivity(isPortraitScreen, isCancelStatusBar) {

    protected val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        val factory = getViewModelFactory()
        if (factory == null) {
            ViewModelProvider(this)[getGenericClassFromSuperClass()] as VM
        } else {
            ViewModelProvider(this, factory)[getGenericClassFromSuperClass()] as VM
        }
    }

    protected open fun getViewModelFactory(): ViewModelProvider.Factory? = null
}