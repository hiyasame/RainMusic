package kim.bifrost.rain.rainmusic.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kim.bifrost.rain.rainmusic.api.user.User
import kim.bifrost.rain.rainmusic.base.ui.mvvm.BaseVmBindFragment
import kim.bifrost.rain.rainmusic.databinding.FragmentSquareBinding
import kim.bifrost.rain.rainmusic.model.web.api.NeteaseCloudApi
import kim.bifrost.rain.rainmusic.model.web.bean.EverydayLyricBean
import kim.bifrost.rain.rainmusic.utils.extensions.htmlDecode
import kim.bifrost.rain.rainmusic.utils.extensions.mmkv
import kim.bifrost.rain.rainmusic.view.adapter.NewSongAdapter
import kim.bifrost.rain.rainmusic.view.adapter.SquarePlayListAdapter
import kim.bifrost.rain.rainmusic.view.viewmodel.SquareFragViewModel
import kotlinx.coroutines.launch
import java.util.*

/**
 * kim.bifrost.rain.rainmusic.view.fragment.SquareFragment
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/26 22:21
 **/
class SquareFragment : BaseVmBindFragment<SquareFragViewModel, FragmentSquareBinding>() {
    @SuppressLint("SetTextI18n")
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
        lifecycleScope.launch {
            val bean = getEveryDayPoem()
            binding.apply {
                tvEverydayLyric.text = bean.data.content.htmlDecode()
                tvLyricAuthor.text = bean.data.singer
                tvLyricSong.text = "《${bean.data.song}》"
            }
        }
    }

    private fun load(user: User) {
        binding.apply {
            lifecycleScope.launch {
                rvPlaylistRecommend.apply {
                    layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.HORIZONTAL, false)
                    adapter = SquarePlayListAdapter(viewModel.getRecommendPlayList()) {
                        // TODO 跳转到歌单界面
                    }
                }
                rvSongRecommend.apply {
                    layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
                    adapter = NewSongAdapter(viewModel.getNewSongs()) {
                        // TODO 播放歌曲
                    }
                }
                srlSquare.isRefreshing = false
            }
        }
    }

    // 由于接口访问次数限制做出的妥协
    // 每日一首诗，缓存
    private suspend fun getEveryDayPoem(): EverydayLyricBean {
        val date = Date()
        var bean = mmkv().decodeParcelable(date.day.toString(), EverydayLyricBean::class.java)
        if (bean == null) {
            bean = viewModel.getLyrics()
            mmkv().encode(date.day.toString(), bean)
        }
        return bean
    }
}