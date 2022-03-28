package kim.bifrost.rain.rainmusic.view.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kim.bifrost.rain.rainmusic.api.user.NeteaseUser
import kim.bifrost.rain.rainmusic.base.ui.mvvm.BaseVmBindFragment
import kim.bifrost.rain.rainmusic.databinding.FragmentMyBinding
import kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi
import kim.bifrost.rain.rainmusic.view.activity.LoginActivity
import kim.bifrost.rain.rainmusic.view.adapter.MyPlayListAdapter
import kim.bifrost.rain.rainmusic.view.viewmodel.MyFragViewModel
import kotlinx.coroutines.launch

/**
 * kim.bifrost.rain.rainmusic.view.fragment.MyFragment
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 22:18
 **/
class MyFragment : BaseVmBindFragment<MyFragViewModel, FragmentMyBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        NeteaseCloudApi.user.observeNotNull {
            // 加载登录信息
            Glide.with(requireContext())
                .load(it.profile.avatar)
                .into(binding.ivAvatar)
            binding.tvName.text = it.profile.name
            load(it)
        }
        // 加载登录信息
        viewModel.initUser()
        // 点击登录
        binding.topArea.setOnClickListener {
            LoginActivity.start(requireContext())
        }
    }

    private fun load(user: NeteaseUser) {
        lifecycleScope.launch {
            val data = viewModel.getUserPlayList(user.uid).playlist
            binding.rvPlaylist.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = MyPlayListAdapter(data)
            }
        }
    }
}