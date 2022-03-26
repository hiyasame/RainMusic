package kim.bifrost.rain.rainmusic.base.ui

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.LiveData
import kim.bifrost.rain.rainmusic.utils.BindView
import java.lang.RuntimeException
import java.lang.reflect.ParameterizedType

/**
 *@author 985892345
 *@email 2767465918@qq.com
 *@data 2021/5/25
 *@description
 */
abstract class BaseActivity(
    /**
     * 是否锁定竖屏
     */
    private val isPortraitScreen: Boolean = true,

    /**
     * 是否沉浸式状态栏
     */
    private val isCancelStatusBar: Boolean = true
) : AppCompatActivity() {

    @CallSuper
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isPortraitScreen) { // 锁定竖屏
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        if (isCancelStatusBar) { // 沉浸式状态栏
            cancelStatusBar()
        }
    }

    private fun cancelStatusBar() {
        val window = this.window
        val decorView = window.decorView

        // 这是 Android 做了兼容的 Compat 包
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val windowInsetsController = ViewCompat.getWindowInsetsController(decorView)
        windowInsetsController?.isAppearanceLightStatusBars = true // 设置状态栏字体颜色为黑色
        window.statusBarColor = Color.TRANSPARENT //把状态栏颜色设置成透明
    }

    /**
     * 得到父类中的泛型 Class 对象
     *
     * **NOTE:** 你想找到的泛型必须在继承时明确, 不能为 T 这种不明确的类型, 如下所示
     * ```
     *
     * 简单的三个类
     * Class Test、Class Son、Class Parent
     *
     * 正确用法: Class Son : Parent<String>
     *     这样写就可以得到 Class<String>
     *
     * 错误用法: Class Son<T: Test> : Parent<T>
     *     这样写得到的是 T, 没错, 真的是 T, 这是无法得到传入时 T 的具体类型的
     * ```
     */
    @Suppress("UNCHECKED_CAST")
    protected inline fun <reified T> getGenericClassFromSuperClass(): Class<T> {
        val genericSuperclass = javaClass.genericSuperclass // 得到继承的父类填入的泛型（必须是具体的类型，不能是 T 这种东西）
        if (genericSuperclass is ParameterizedType) {
            val typeArguments = genericSuperclass.actualTypeArguments
            for (type in typeArguments) {
                if (type is Class<*> && T::class.java.isAssignableFrom(type)) {
                    return type as Class<T>
                } else if (type is ParameterizedType) { // 泛型中有泛型时并不为 Class<*>
                    val rawType = type.rawType // 这时 rawType 一定是 Class<*>
                    if (rawType is Class<*> && T::class.java.isAssignableFrom(rawType)) {
                        return rawType as Class<T>
                    }
                }
            }
        }
        throw RuntimeException("你父类的泛型为: $genericSuperclass, 其中不存在 ${T::class.java.simpleName}")
    }

    inline fun <T> LiveData<T?>.observeNotNull(
        crossinline onChange: (T) -> Unit
    ) = observe(this@BaseActivity) {
        it ?: return@observe
        onChange(it)
    }

    /**
     * 在简单界面，使用这种方式来得到 View，避免使用 DataBinding 大材小用
     * ```
     * 使用方法：
     *    val mTvNum: TextView by R.id.xxx.view()
     * or
     *    val mTvNum by R.id.xxx.view<TextView>()
     *
     * 方便程度比较：
     *    kt 插件(被废弃) > 属性代理 > ButterKnife(被废弃) > DataBinding > ViewBinding
     * ```
     */
    protected fun <T: View> Int.view() = BindView<T>(this, { window.decorView }, { lifecycle })

    protected inline fun <reified F: Fragment> replaceFragment(@IdRes id: Int, func: () -> F): F {
        var fragment = supportFragmentManager.findFragmentById(id)
        if (fragment !is F) {
            fragment = func.invoke()
            supportFragmentManager.commit {
                replace(id, fragment)
            }
        }
        return fragment
    }
}
