package kim.bifrost.rain.rainmusic.base.ui

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import kim.bifrost.rain.rainmusic.utils.BindView
import java.lang.RuntimeException
import java.lang.reflect.ParameterizedType

abstract class BaseFragment : Fragment() {
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
    ) = observe(this@BaseFragment) {
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
    protected fun <T: View> Int.view() = BindView<T>(
        this, { requireView() }, { viewLifecycleOwner.lifecycle })
}