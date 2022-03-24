package kim.bifrost.rain.rainmusic.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import kim.bifrost.rain.rainmusic.utils.extensions.invokeStatic

/**
 * .....
 * @author 985892345
 * @email 2767465918@qq.com
 * @data 2021/6/2
 */
abstract class BaseBindFragment<DB: ViewBinding> : BaseFragment() {

    abstract override fun onViewCreated(view: View, savedInstanceState: Bundle?)

    protected lateinit var binding: DB
        private set

    @Deprecated(
        "不要重写该方法，请使用 onViewCreated() 代替",
        ReplaceWith("onViewCreated(view, savedInstanceState)"),
        DeprecationLevel.HIDDEN
    )
    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getGenericClassFromSuperClass<ViewBinding>().invokeStatic<DB>(
            "inflate",
            layoutInflater,
            container,
            false
        )!!
        return binding.root
    }
}