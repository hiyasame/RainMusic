package kim.bifrost.rain.rainmusic.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kim.bifrost.rain.rainmusic.api.IStandardPlayList
import kim.bifrost.rain.rainmusic.databinding.ItemPlayList1Binding

/**
 * kim.bifrost.rain.rainmusic.view.adapter.MyPlayListAdapter
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/27 1:12
 **/
class MyPlayListAdapter(private val list: List<IStandardPlayList>) : RecyclerView.Adapter<MyPlayListAdapter.Holder>() {
    inner class Holder(val binding: ItemPlayList1Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemPlayList1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            tvName.text = list[position].name
            tvTrackCount.text = list[position].count.toString()
            Glide.with(ivCover)
                .load(list[position].coverImgUrl)
                .into(ivCover)
        }
    }

    override fun getItemCount(): Int = list.size
}