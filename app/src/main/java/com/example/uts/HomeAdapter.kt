package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter (private val context: Context, private val novel: List<NovelClass>, val listener: (NovelClass) -> Unit)
    : RecyclerView.Adapter<HomeAdapter.AnimeViewHolder>(){
    class AnimeViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val novelimg = view.findViewById<ImageView>(R.id.img_item_photo)
        val novelname = view.findViewById<TextView>(R.id.tv_item_name)
        val noveldesc = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindView(novel: NovelClass, listener: (NovelClass) -> Unit){
            novelimg.setImageResource(novel.novelimg)
            novelname.text = novel.novelname
            noveldesc.text = novel.noveldesc
            itemView.setOnClickListener{
                (listener(novel))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bindView(novel[position], listener)
    }

    override fun getItemCount(): Int = novel.size

}