package kim.bifrost.rain.rainmusic.view.activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.core.view.GravityCompat
import androidx.core.view.postDelayed
import androidx.fragment.app.commit
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import eightbitlab.com.blurview.RenderScriptBlur
import kim.bifrost.rain.rainmusic.R
import kim.bifrost.rain.rainmusic.base.BaseVPAdapter
import kim.bifrost.rain.rainmusic.base.ui.BaseBindActivity
import kim.bifrost.rain.rainmusic.databinding.ActivityMainBinding
import kim.bifrost.rain.rainmusic.utils.extensions.gone
import kim.bifrost.rain.rainmusic.utils.extensions.setOnEnd
import kim.bifrost.rain.rainmusic.view.fragment.MyFragment
import kim.bifrost.rain.rainmusic.view.fragment.SplashFragment
import kim.bifrost.rain.rainmusic.view.fragment.SquareFragment

class MainActivity : BaseBindActivity<ActivityMainBinding>(isCancelStatusBar = true) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashFragment = replaceFragment(R.id.splash_screen) {
            SplashFragment()
        }

        // 使用 Handler 更轻量级一些
        binding.splashScreen.postDelayed(1600) {
            // 来个淡出动画，它不香吗？:)
            binding.splashScreen.startAnimation(
                AlphaAnimation(1F, 0F).apply {
                    duration = 400
                    setOnEnd {
                        supportFragmentManager.commit {
                            remove(splashFragment)
                        }
                        binding.splashScreen.gone() // 这里使用 GONE 要好一些，因为 INVISIBLE 是会拦截点击事件的
                    }
                }
            )
        }
        // DrawerLayout 的状态栏颜色
        binding.dl.setStatusBarBackgroundColor(Color.TRANSPARENT)
        binding.vpMain.adapter =
            BaseVPAdapter(supportFragmentManager, lifecycle, listOf(1, 2)) { _, i ->
                when (i) {
                    0 -> MyFragment()
                    1 -> SquareFragment()
                    else -> error("error state")
                }
            }
        TabLayoutMediator(binding.tlMain, binding.vpMain) { tab, i ->
            when (i) {
                0 -> tab.text = "我的"
                1 -> tab.text = "发现"
            }
        }.attach()

        val radius = 20f
        val decorView: View = window.decorView
        val windowBackground: Drawable = decorView.background
        binding.blurViewPlay.setupWith(decorView.findViewById(R.id.cdl))
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setHasFixedTransformationMatrix(true)

        binding.toolbar.setNavigationOnClickListener {
            binding.dl.openDrawer(GravityCompat.START)
        }
    }
}