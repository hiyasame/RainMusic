package kim.bifrost.rain.rainmusic.utils.extensions

import android.view.animation.Animation

/**
 * ...
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/3/24 23:14
 */

/**
 * 注意，这个因为是 setAnimationListener() 的原因，所以只能设置一次，但一般都是只用 onEnd
 */
fun Animation.setOnEnd(func: () -> Unit) {
    setAnimationListener(
        object : Animation(), Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }
            override fun onAnimationEnd(animation: Animation) {
                func.invoke()
            }
            override fun onAnimationRepeat(animation: Animation) {
            }
        }
    )
}



