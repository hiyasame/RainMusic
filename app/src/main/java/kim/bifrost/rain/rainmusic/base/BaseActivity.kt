package kim.bifrost.rain.rainmusic.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kim.bifrost.rain.rainmusic.utils.invokeStatic
import java.lang.reflect.ParameterizedType

/**
 * kim.bifrost.rain.rainmusic.base.BaseActivity
 * WanAndroid
 *
 * @author 寒雨
 * @since 2021/11/21 1:55
 **/
abstract class BaseActivity<DB : ViewBinding>(
    private val isCancelStatusBar: Boolean = true,
) : AppCompatActivity() {

    protected val binding: DB by lazy {
        getViewBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (isCancelStatusBar) {
            cancelStatusBar()
        }
    }

    // 我不管性能了 我就要解耦！！！
    private fun getViewBinding(): DB {
        return ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments
            .first { it is Class<*> && ViewBinding::class.java.isAssignableFrom(it) } as Class<*>)
            .invokeStatic<DB>("inflate", layoutInflater)!!
    }

    @Suppress("DEPRECATION")
    private fun cancelStatusBar() {
        // Android 11 以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // 隐藏状态栏
//            window.setDecorFitsSystemWindows(false)
            // 状态栏字体变黑
            window.decorView.windowInsetsController?.setSystemBarsAppearance(
                APPEARANCE_LIGHT_STATUS_BARS,
                APPEARANCE_LIGHT_STATUS_BARS)
        } else {
            // 取消状态栏，已经做了判断使用
            val option = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            window.decorView.systemUiVisibility = option
            // 状态栏字体颜色变黑
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or option
        }
        // 状态栏设置成透明
        window.statusBarColor = Color.TRANSPARENT
    }

}