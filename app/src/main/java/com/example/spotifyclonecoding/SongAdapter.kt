package com.example.spotifyclonecoding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclonecoding.databinding.RecommendHolderBinding
import com.example.spotifyclonecoding.databinding.SongHolderBinding

class SongAdapter(private val items: PlaySongList) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MultiViewEnum.SONG.viewType -> {
                val binding =
                    SongHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SongHolder(binding)
            }

            MultiViewEnum.RECOMMEND.viewType -> {
                val binding = RecommendHolderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                RecommendHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is SongHolder -> {
                holder.bind(items.SongList[position])
            }

            is RecommendHolder -> {
                holder.bind(items.playList[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items.viewType.viewType
    }

    override fun getItemCount(): Int {
        return if(items.viewType == MultiViewEnum.SONG){
            items.SongList.size
        }else{
            items.playList.size
        }
    }

}



class SongHolder(private val binding: SongHolderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(song: Song) {
            binding.apply {
                ivSongCover.setImageResource(song.cover)
                tvSongName.text = song.song
                tvArtistName.text = song.artist
            }
        }
    }



class RecommendHolder(private val binding: RecommendHolderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PlayList) {
        binding.apply {
            ivCoverPlayList.setImageResource(item.cover)
            tvPlaylistName.text = item.playlistName
            tvPlaylistDesc.text = item.desc
        }

    }
}


