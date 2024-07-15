package com.example.spotifyclonecoding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecentPlayAdapter(private val items : MutableList<PlayList>) :RecyclerView.Adapter<RecentPlayAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentPlayAdapter.Holder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recent_playlist_holder,parent,false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: RecentPlayAdapter.Holder, position: Int) {
        holder.cover.setImageResource(items[position].cover)
        holder.playListName.text = items[position].playlistName
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view){
        val cover : ImageView = view.findViewById(R.id.iv_playlist)
        val playListName : TextView = view.findViewById(R.id.tv_playlist)
    }


}