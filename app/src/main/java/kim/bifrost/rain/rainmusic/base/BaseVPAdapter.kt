package kim.bifrost.rain.rainmusic.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * kim.bifrost.rain.bilibili.ui.view.adapter.StandardVPAdapter
 * BiliBili
 *
 * @author 寒雨
 * @since 2022/1/19 13:57
 **/
class BaseVPAdapter<D : Any>(
    fragment: FragmentManager,
    lifecycle: Lifecycle,
    private val types: List<D>,
    private val createFragmentFunc: (List<D>, Int) -> Fragment
) : FragmentStateAdapter(fragment, lifecycle) {

    override fun getItemCount(): Int = types.size

    override fun createFragment(position: Int): Fragment {
        return createFragmentFunc(types, position)
    }
}