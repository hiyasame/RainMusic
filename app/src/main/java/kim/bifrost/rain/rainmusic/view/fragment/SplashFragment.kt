package kim.bifrost.rain.rainmusic.view.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.core.view.postDelayed
import androidx.lifecycle.lifecycleScope
import kim.bifrost.rain.rainmusic.base.ui.mvvm.BaseVmBindFragment
import kim.bifrost.rain.rainmusic.databinding.FragmentSplashBinding
import kim.bifrost.rain.rainmusic.utils.extensions.gone
import kim.bifrost.rain.rainmusic.utils.extensions.setOnEnd
import kim.bifrost.rain.rainmusic.view.viewmodel.SplashFragViewModel
import kotlinx.coroutines.launch

/**
 * kim.bifrost.rain.rainmusic.view.fragment.SplashFragment
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/23 1:11
 **/
class SplashFragment : BaseVmBindFragment<SplashFragViewModel, FragmentSplashBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObserve()
    }

    private fun initObserve() {
        viewModel.mPoemData.observeNotNull {
            binding.tvPoem.text = it.hitokoto
        }
    }
}