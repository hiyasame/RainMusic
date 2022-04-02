package kim.bifrost.rain.rainmusic.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kim.bifrost.rain.rainmusic.api.IStandardPlayList
import kim.bifrost.rain.rainmusic.databinding.ItemPlayList2Binding

/**
 * kim.bifrost.rain.rainmusic.view.adapter.SquarePlayListAdapter
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/27 13:28
 **/
class SquarePlayListAdapter(
    private val items: List<IStandardPlayList>,
    private val onClick: IStandardPlayList.() -> Unit
    ) : RecyclerView.Adapter<SquarePlayListAdapter.Holder>() {
    inner class Holder(val binding: ItemPlayList2Binding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                items[bindingAdapterPosition].onClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemPlayList2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = items[position]
        holder.binding.apply {
            Glide.with(ivAvatar)
                .load(data.coverImgUrl)
                .into(ivAvatar)
            tvName.text = data.name
            tvPlayCount.text = tvPlayCount.text.toString().replace("%d", (data.playCounts / 10000).toString())
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}