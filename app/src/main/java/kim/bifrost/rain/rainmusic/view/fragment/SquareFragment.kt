package kim.bifrost.rain.rainmusic.view.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kim.bifrost.rain.rainmusic.api.user.User
import kim.bifrost.rain.rainmusic.base.ui.mvvm.BaseVmBindFragment
import kim.bifrost.rain.rainmusic.databinding.FragmentSquareBinding
import kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi
import kim.bifrost.rain.rainmusic.view.adapter.SquarePlayListAdapter
import kim.bifrost.rain.rainmusic.view.viewmodel.SquareFragViewModel
import kotlinx.coroutines.launch

/**
 * kim.bifrost.rain.rainmusic.view.fragment.SquareFragment
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 22:21
 **/
class SquareFragment : BaseVmBindFragment<SquareFragViewModel, FragmentSquareBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (NeteaseCloudApi.hasLogin) {
            load(NeteaseCloudApi.user.value!!)
        }
        NeteaseCloudApi.user.observeNotNull {
            load(it)
        }
        binding.srlSquare.setOnRefreshListener {
            if (NeteaseCloudApi.hasLogin) {
                load(NeteaseCloudApi.user.value!!)
            } else {
                binding.srlSquare.isRefreshing = false
            }
        }
    }

    private fun load(user: User) {
        binding.apply {
            lifecycleScope.launch {
                rvPlaylistRecommend.apply {
                    layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.HORIZONTAL, false)
                    adapter = SquarePlayListAdapter(viewModel.getRecommendPlayList(user.uid))
                }
                srlSquare.isRefreshing = false
            }
        }
    }
}