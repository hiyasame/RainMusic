package kim.bifrost.rain.rainmusic.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kim.bifrost.rain.rainmusic.api.IStandardMusicInfo
import kim.bifrost.rain.rainmusic.databinding.ItemSong1Binding

/**
 * kim.bifrost.rain.rainmusic.view.adapter.NewSongAdapter
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/4/2 17:13
 **/
class NewSongAdapter(
    private val res: List<IStandardMusicInfo>,
    private val onClick: IStandardMusicInfo.() -> Unit
    ) : RecyclerView.Adapter<NewSongAdapter.Holder>() {
    inner class Holder(val binding: ItemSong1Binding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                res[bindingAdapterPosition].onClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemSong1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = res[position]
        holder.binding.apply {
            Glide.with(ivAvatar)
                .load(data.imageUrl.replaceFirst("http", "https"))
                .into(ivAvatar)
            tvAuthor.text = data.artists.joinToString(" / ") { it.name }
            tvName.text = data.name
        }
    }

    override fun getItemCount(): Int = res.size
}