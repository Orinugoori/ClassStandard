package com.example.spotifyclonecoding

import android.graphics.Color
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView

class HorizontalAdapter(private val item : MutableList<PlayList>) :RecyclerView.Adapter<HorizontalAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalAdapter.Holder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_holder,parent,false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: HorizontalAdapter.Holder, position: Int) {
        //아티스트 사진
        holder.coverImage.setImageResource(item[position].cover)

        //각 플레이 리스트별 프레임
        if (item[position].decoPhoto == null){
            holder.decoPhoto.visibility = View.INVISIBLE
        }else{
            holder.decoPhoto.setImageResource(item[position].decoPhoto!!)
        }

        //logo
        if (item[position].logo == null){
            holder.logo.visibility = View.INVISIBLE
        }else{
            holder.logo.setImageResource(item[position].logo!!)
        }

        //playList 이름
        if (item[position].playlistName == null){
            holder.playListName.visibility = View.INVISIBLE
        }else{
            holder.playListName.text = item[position].playlistName
            if(item[position].textColor == 1){
                holder.playListName.setTextColor(Color.parseColor("#000000"))

                val layoutParams = holder.playListName.layoutParams as FrameLayout.LayoutParams
                layoutParams.setMargins(0,0,0,20)
            }else{
                holder.playListName.setTextColor(Color.parseColor("#ffffff"))
            }
        }

        //플레이리스트 설명
        holder.desc.text = item[position].desc
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class Holder(view : View):RecyclerView.ViewHolder(view){
        val coverImage : ImageView = view.findViewById(R.id.iv_cover_image)
        val decoPhoto :ImageView = view.findViewById(R.id.iv_deco_photo)
        val logo : ImageView = view.findViewById(R.id.ic_logo)
        val playListName : TextView = view.findViewById(R.id.tv_mix_name)
        val desc : TextView = view.findViewById(R.id.tv_artist_names)
    }
}
