package kim.bifrost.rain.rainmusic.view.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import kim.bifrost.rain.rainmusic.R
import kim.bifrost.rain.rainmusic.base.BaseActivity
import kim.bifrost.rain.rainmusic.databinding.ActivityMainBinding
import kim.bifrost.rain.rainmusic.view.fragment.SplashFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportFragmentManager.findFragmentById(R.id.splash_screen) == null) {
            supportFragmentManager.commit {
                replace(R.id.splash_screen, SplashFragment())
            }
        }
        // 其余控件加载完毕
        lifecycleScope.launch {
            delay(2000)
            binding.apply {
                splashScreen.visibility = View.INVISIBLE
            }
        }
    }
}