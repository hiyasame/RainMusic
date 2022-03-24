package kim.bifrost.rain.rainmusic.base.ui.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kim.bifrost.rain.rainmusic.base.ui.BaseFragment

abstract class BaseVmFragment<VM: ViewModel>: BaseFragment() {

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