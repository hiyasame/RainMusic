package kim.bifrost.rain.rainmusic.view.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import kim.bifrost.rain.rainmusic.base.BaseVMFragment
import kim.bifrost.rain.rainmusic.databinding.FragmentSplashBinding
import kim.bifrost.rain.rainmusic.view.viewmodel.SplashFragViewModel
import kotlinx.coroutines.launch

/**
 * kim.bifrost.rain.rainmusic.view.fragment.SplashFragment
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/23 1:11
 **/
class SplashFragment : BaseVMFragment<SplashFragViewModel, FragmentSplashBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            val poem = viewModel.getPoem().hitokoto
            binding.tvPoem.text = poem
        }
    }
}