package com.han.highjune.ViewModelList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewGroupCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.han.highjune.R
import com.han.highjune.model.Music

class VMListAdapter :ListAdapter<Music,VMListViewHolder>(Music.DIFF_CALLBACK){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VMListViewHolder {
        return VMListViewHolder(parent)
    }

    override fun onBindViewHolder(holder: VMListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class VMListViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.vm_list_item, parent, false)
) {

    private val vm_iv: ImageView = itemView.findViewById(R.id.vm_iv)
    private val vmTitle: TextView = itemView.findViewById(R.id.vmTitle)
    private val vmBody: TextView = itemView.findViewById(R.id.vmBody)


    init {
        ViewGroupCompat.setTransitionGroup(itemView as ViewGroup, true)
    }

    fun bind(music: Music) {
        vmTitle.text = music.mTitle
        vmBody.text = music.mBody
    }
}